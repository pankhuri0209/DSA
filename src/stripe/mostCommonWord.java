package stripe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class mostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban= new HashSet<String>();
        for(String b: banned){ban.add(b.toLowerCase());}
        //normalize
        String cleaned= paragraph.toLowerCase().replaceAll("[^a-z]"," ");
        String[] words=cleaned.split("\\s+");

        HashMap<String,Integer> map=new HashMap<String,Integer>();
        String best="";
        int bestCount=0;

        for(String w: words){
            if (w.isEmpty() || ban.contains(w)) {
                continue;
            }
            int c = map.getOrDefault(w,0)+1;
            map.put(w,c);
            if(c>bestCount) {
                bestCount = c;
                best = w;
            }
        }
        return best;
    }
}
