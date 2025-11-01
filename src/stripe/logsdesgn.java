package stripe;
import java.util.*;
public class logsdesgn {
    class LogSystem {

        private List<Pair> logs;
        private Map<String, Integer> granularityMap;

        public LogSystem() {
            logs = new ArrayList<Pair>();
            granularityMap= new HashMap<>();
            granularityMap.put("Year", 4);
            granularityMap.put("Month", 7);
            granularityMap.put("Day", 10);
            granularityMap.put("Hour", 13);
            granularityMap.put("Minute", 16);
            granularityMap.put("Second", 19);
        }
        public void put(int id, String timestamp)
        {
            logs.add(new Pair(id, timestamp));
        }
        public List<Integer> retrieve(String start, String end, String granularity)
        {
            int len= granularityMap.get(granularity);
            start= start.substring(0, len);
            end= end.substring(0, len);
            List<Integer> res= new ArrayList<>();
            for(Pair log:logs)
            {
                String ts= log.timeStamp.substring(0, len);
                if (ts.compareTo(start)>=0 && ts.compareTo(end)<=0)
                {
                    res.add(log.id);
                }
            }
            return res;
        }
    }
    private static class Pair{
        int id;
        String timeStamp;
        Pair(int id, String timeStamp){
            this.id = id;
            this.timeStamp = timeStamp;
        }
    }
}
