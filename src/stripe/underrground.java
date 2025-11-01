package stripe;

import java.util.HashMap;
import java.util.Map;

public class underrground {
    class UndergroundSystem {
        private Map<Integer, CheckInInfo> checkInMap;
        private  Map<String, TravelData> travelMap;

        public UndergroundSystem() {
            this.checkInMap = new HashMap<Integer, CheckInInfo>();
            this.travelMap = new HashMap<String, TravelData>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new CheckInInfo(stationName, t));
        }

        public void checkOut(int id, String endStation, int t) {
            CheckInInfo info = checkInMap.get(id);
            checkInMap.remove(id); //done travelling
            String route= info.stationName + "_"+ endStation;
            int travelTime= t- info.time;

            TravelData travelData = travelMap.getOrDefault(route, new TravelData(0,0));
            travelData.totalTime += travelTime;
            travelData.count+=1;
            travelMap.put(route, travelData);
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "_"+ endStation;
            TravelData travelData= travelMap.get(route);
            return (double) travelData.totalTime/travelData.count;
        }
        private static class CheckInInfo{
            String  stationName;
            int time;
            CheckInInfo(String stationName, int time) {
                this.stationName = stationName;
                this.time = time;
            }
        }
        private static class TravelData{
            int totalTime;
            int count;
            TravelData(int totalTime, int count) {
                this.totalTime = totalTime;
                this.count = count;
            }
        }
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
}
