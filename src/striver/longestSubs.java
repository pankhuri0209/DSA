package striver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class longestSubs {
    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new LinkedHashMap<>();
        int res=0;
        for(int i =0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else
            {
                map.put(s.charAt(i),1);
            }
        }
        int j=0,max=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            Integer value = entry.getValue();
            if (value != null && value.equals(1)) {
                res+=1;
            }
            else
            {
                res=0;
            }
            max=Math.max(res,max);
            j++;
        }
        return max;

    }
    public static void main(String[] args)
    {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
