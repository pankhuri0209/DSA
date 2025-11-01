package stripe;

import java.util.*;

public class alert {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        //convert each time to minutes and store per employee
        for(int i = 0; i < keyName.length; i++){
            String name= keyName[i];
            String time= keyTime[i];

            //convert time HH:MM into minutes
            int mins= Integer.parseInt(time.substring(0,2)) *60+ Integer.parseInt(time.substring(3));
            map.computeIfAbsent(name, k-> new ArrayList<>()).add(mins);
        }
        List<String> list = new ArrayList<>();
        for (String name: map.keySet()) {
            List<Integer> times = new ArrayList<>();
            Collections.sort(times);
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i)- times.get(i-2) <=60)
                {
                    list.add(name);
                    break;
                }
            }
        }
        Collections.sort(list);
        return   list;
    }
}
