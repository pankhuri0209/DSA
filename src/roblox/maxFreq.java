package roblox;

import java.util.HashMap;
import java.util.Map;

public class maxFreq {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize)
    {
        Map<String, Integer>  freqMap= new HashMap<>();
        int maxFreq=0;

        for(int i=0;i<=s.length()-minSize;i++)
        {
            String subStr = s.substring(i,i+minSize);

            if (counUniqChars(subStr) <=maxLetters)
            {
                freqMap.put(subStr, freqMap.getOrDefault(subStr,0)+1);
                maxFreq = Math.max(maxFreq, freqMap.get(subStr));
            }
        }
        return maxFreq;
    }
    private int counUniqChars(String str)
    {
        boolean[] charSet= new boolean[26];
        int uniqueCount=0;

        for (char c: str.toCharArray())
        {
            if (!charSet[c-'a'])
            {
                charSet[c-'a'] = true;
                uniqueCount++;
            }
        }
        return uniqueCount;
    }
}
