package stripe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class domains {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String entry : cpdomains){
            String[] split= entry.split(" ");
            int count= Integer.parseInt(split[0]);
            String domain = split[1];

            //build all subdomains
            String[] labels= domain.split("\\.");
            String cur="";
            for (int i=labels.length-1;i>=0;i--){
                cur=cur.isEmpty() ? labels[i] : labels[i]+"." +cur;
                map.put(cur, map.getOrDefault(cur, 0) + count);

            }
        }
        List<String> res= new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() +" "+ entry.getKey());
        }
        return res;
    }
    public List<String> subdomainVisits1(String[] cpdomains) {
        Map<String, Integer> map =new HashMap<>();
        for(String entry : cpdomains){
            String[] split= entry.split(" ");
            int count= Integer.parseInt(split[0]);
            String domain = split[1];
            String[] labels= domain.split("\\.");
            String cur="";
            for (int i=labels.length-1;i>=0;i--){
                cur=cur.isEmpty() ? labels[i] : labels[i]+"." +cur;
                map.put(cur, map.getOrDefault(cur, 0) + count);
            }
        }
        List<String> res= new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() +" "+ entry.getKey());
        }
        return res;
    }
}
