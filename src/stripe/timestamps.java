package stripe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class timestamps {
    class TimeMap {
        HashMap<String , List<TimeMapKey>> map;
        public TimeMap() {
            this.map = new HashMap<String , List<TimeMapKey>>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k->new ArrayList<>()).add(new TimeMapKey(value,timestamp));
        }

        public String get(String key, int timestamp) {

            if(!map.containsKey(key)) {
                return "";
            }
            List<TimeMapKey> list = map.get(key);
            int right = list.size()-1, left=0;
            String res="";
            while(left<=right) {
                int mid = left+(right-left)/2;
                if (list.get(mid).timestamp<=timestamp) {
                    res= list.get(mid).value;
                    left=mid+1;
                }
                else {
                    right=mid-1;
                }
            }
            return res;
        }

        public class TimeMapKey {
            String value;
            int timestamp;
            public TimeMapKey(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;

            }
        }

    }


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
