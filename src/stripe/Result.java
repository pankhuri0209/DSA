package stripe;

import com.sun.jdi.connect.spi.Connection;

import java.util.*;

public class Result {
    public static List<String> route_requests(int numTargets, int maxConnectionsPerTarget, List<String> requests) {
        //Initialzation block
        int [] load = new int[numTargets];

        //connectionId -> targetIndex
        Map<String, Integer> connToTarget= new HashMap<String, Integer>();
        Map<String, String> connToUser= new HashMap<>();
        Map<String, String> connToObj= new HashMap<>();

        Map<String, Integer> objToTarget= new HashMap<>();
        //objTd -> active connection count (to know how many to free objtoTarget mapping)
        Map<String, Integer> objUseCount= new HashMap<>();

        //targetIndex -> active connectionIds (we store to gather eviections on SHUTDOWN)
        Map<Integer, Set<String>> targetCons= new HashMap<>();
        for (int i=1;i<=numTargets;i++) {
            targetCons.put(i, new HashSet<>());
        }
        List<String> log= new ArrayList<>();

        //-1 means "no target is temporirly unavailable"; otherwise 1 ..numTargets is unavailable
        int unavailableTarget=-1;

        class Picker{
            int pick(int excludeTarget){
                int bestIdx=-1;
                int bestLoad= Integer.MAX_VALUE;
                for (int i=1;i<=numTargets;i++) {
                    if (i==excludeTarget) {
                        continue;
                    }
                    if (maxConnectionsPerTarget>0 && load[i-1]>=maxConnectionsPerTarget) {
                        continue;
                    }
                    if (load[i-1]<bestLoad || (load[i-1] ==bestLoad && i<bestIdx)) {
                        bestLoad= load[i-1];
                        bestIdx=i;
                    }
                }
                return bestIdx;
            }
        }
        Picker picker = new Picker();

        class Connector{
            boolean connect(String connId, String userId, String objId, int tempUnavailable)
            {
                Integer pinned= objToTarget.get(objId);
                int target;
                if (pinned!=null)
                {
                    if ((tempUnavailable==pinned) ||
                            (maxConnectionsPerTarget>0 && load[pinned-1]>=maxConnectionsPerTarget))
                    {
                        return false; //Reject
                    }
                    target=pinned;
                }
                else {
                    target= picker.pick(tempUnavailable);
                    if (target==-1){
                        return false; //reject
                    }
                }
                connToTarget.put(connId, target);
                connToUser.put(connId, userId);
                connToObj.put(connId, objId);
                targetCons.get(target).add(connId);

                load[target-1]++;
                objToTarget.put(objId, target);
                objUseCount.put(objId, objUseCount.getOrDefault(objId, 0) + 1);

                log.add(connId+","+userId+","+objId);
                return true;
            }
        }
        Connector connector = new Connector();
        class Disconnector{
            void disconnectByConnId(String connId){
                Integer t= connToTarget.get(connId);
                if (t==null) { // shouldnt happen in valid input
                    return;
                }
                String objId = connToObj.get(connId);
                targetCons.get(t).remove(objId);
                connToTarget.remove(connId);
                String user = connToUser.get(connId);
                connToObj.remove(connId);

                load[t-1]--;
                int left= objUseCount.getOrDefault(objId, 0)-1;
                if (left<=0)
                {
                    objUseCount.remove(objId);
                    objToTarget.remove(objId);
                }
                else {
                    objUseCount.put(objId, left);
                }
            }
        }
        Disconnector disconnector = new Disconnector();
        for (String line: requests)
        {
            String[] tok= line.split(",",-1);
            String action=tok[0].trim();

            if ("CONNECT".equals(action))
            {
                String connId=tok[1].trim();
                String userId=tok[2].trim();
                String objId=tok[3].trim();

                connector.connect(connId, userId, objId, -1);
            } else if ("DISCONNECT".equals(action)) {
                String connId=tok[1].trim();
                disconnector.disconnectByConnId(connId);
            }
            else if ("SHUTDOWN".equals(action)) {
                int shutIndex= Integer.parseInt(tok[1].trim());
                Set<String> conns = new HashSet<>(targetCons.get(shutIndex));
                if (!conns.isEmpty()){
                    List<String> evicted=  new ArrayList<>(conns);
                    Collections.sort(evicted);

                    List<String[]> toReconnect= new ArrayList<>();
                    for (String c: evicted) {
                        String u= connToUser.get(c);
                        String o= connToObj.get(c);
                        toReconnect.add(new String[]{c, u, o});
                        disconnector.disconnectByConnId(c);
                    }
                    unavailableTarget=shutIndex;
                    for (String[] triple: toReconnect) {
                        connector.connect(triple[0], triple[1], triple[2], unavailableTarget);
                    }
                    unavailableTarget=-1;
                }
            }
            else{}
        }
        return log;
    }
}
