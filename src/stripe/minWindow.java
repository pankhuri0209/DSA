package stripe;

import java.util.HashMap;
import java.util.Map;

public class minWindow {
    public String minWindow(String s, String t) {

        if(s.length()< t.length())
        {return "";}
        Map<Character,Integer> need = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int minLen= Integer.MAX_VALUE;
        int required= t.length();

        while(right<s.length()){
            char c = s.charAt(right);
            if(need.containsKey(c)){
                if (need.get(c)>0){
                    required--;
                }
                need.put(c, need.get(c)-1);
            }
            //when we have a valid window
            while (required==0)
            {
                if (right-left+1<minLen)
                {
                     minLen = right-left+1;
                     start = left;
                }
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)){
                    need.put(leftChar, need.get(leftChar)+1);
                    if (need.get(leftChar)>0) {
                        required++;
                    }
                }
                    left++;
            }
                right++;
        }

        return minLen==Integer.MAX_VALUE?"":s.substring(start, start+minLen);
    }
}
