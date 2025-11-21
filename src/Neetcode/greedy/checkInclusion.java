package Neetcode.greedy;

public class checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] freq1= new int[26];
        int[] freq2= new int[26];
        int window=n;
        for (int c: s1.toCharArray()) {
            freq1[c-'a']++;
        }
        for (int i = 0; i<m; i++) {
            freq2[s2.charAt(i)-'a']++;
        }
        if (isMatch(freq1,freq2))
        {
            return true;
        }
        for (int i=window; i<m; i++) {
            freq2[s2.charAt(i)-'a']++;
            freq2[s2.charAt(i-window)-'a']--;
            if (isMatch(freq2,freq1))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isMatch(int[] freq1 , int[] freq2) {
       for (int i=0;i<26;i++)
       {
           if (freq1[i]!=freq2[i])
           {
               return false;
           }
       }
        return true;
    }
}
