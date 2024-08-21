package roblox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://chatgpt.com/share/cd9c1e88-c115-4c0e-a715-e822d61dba57
public class subdomainsVisits {

    public List<String> subdomainVisits(String[] cpdomains)
    {
        Map<String,Integer> map= new HashMap<>();
        StringBuilder sb= new StringBuilder();
        for (String s: cpdomains)
        {
            int n= Integer.parseInt(s.substring(0, s.indexOf(" ")));
            String[] d= s.substring(s.indexOf(" ") +1).split("\\.");
            sb.setLength(0);
            for (int i= d.length-1;i>=0;i--)
            {
                sb.insert(0,d[i]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+n);
                if(i!=0)
                {
                    sb.insert(0,".");
                }
            }
        }
        List<String> rs= new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry: map.entrySet())
        {
            rs.add(entry.getValue() +" "+ entry.getKey());
        }
        return rs;
    }
}
