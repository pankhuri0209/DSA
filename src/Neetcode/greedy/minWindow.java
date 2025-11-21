package Neetcode.greedy;

public class minWindow {
    public String minWindow(String s, String t) {
        if (s.length()<t.length()) return "";

        int[] need= new int[128];
        int[] window= new int[128];

        for (char c:t.toCharArray()){
            need[c]++;
        }
        int required = t.length();
        int formed=0;
        int l=0;
        int minLen= Integer.MAX_VALUE;
        int start=0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window[c]++;
            if(need[c]>0 && window[c]<= need[c]){
                formed++;
            }
            while(formed==required){
                //update the best window
                if (r-l+1<minLen){
                    minLen=r-l+1;
                    start=l;
                }
                char leftChar= s.charAt(l);
                window[leftChar]--;
                if (need[leftChar]>0 && window[leftChar]< need[leftChar]){
                    formed--;
                }
                l++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}
