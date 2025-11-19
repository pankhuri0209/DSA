package Neetcode.greedy;

public class maxCount {
    public int characterReplacement(String s, int k) {
        int result=0, maxCount=0, left=0;
        int[] freq= new int[26];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c-'a']++;
            maxCount=Math.max(maxCount,freq[c-'a']);
            while ((right-left+1) - maxCount >k )
            {
                freq[s.charAt(left)-'a']--;
                left++;
            }
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}
