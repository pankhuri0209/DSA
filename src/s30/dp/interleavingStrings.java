package s30.dp;

public class interleavingStrings {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Early check: lengths must match
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // memo[i][j] = can we form s3[0...i+j-1] using s1[0...i-1] and s2[0...j-1]?
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];

        return helper(s1, s2, s3, memo, 0, 0);
    }

    private boolean helper(String s1, String s2, String s3, Boolean[][] memo, int i, int j) {
        // Base case: if we've processed all of s1 and s2
        // We should have also processed all of s3
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        // Check memo
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean result = false;

        // Current position in s3
        int k = i + j;

        // Option 1: Take character from s1 (if possible)
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = helper(s1, s2, s3, memo, i + 1, j);
        }

        // Option 2: Take character from s2 (if possible and option 1 didn't work)
        if (!result && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = helper(s1, s2, s3, memo, i, j + 1);
        }

        // Cache and return result
        memo[i][j] = result;
        return result;
    }

}
