package s30.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordDict {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo= new Boolean[s.length()];

        return helper(s,0, wordSet, memo);
    }
    private boolean helper(String s, int start, Set<String> wordSet, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end =start+1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (wordSet.contains(sub)) {
                if (helper(s, end, wordSet, memo)) {
                    memo[start] = true;
                    return true;
                }
            }
        }
        memo[start] = false;
        return false;
    }
    //tabulation
    public boolean wordBreak1(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
