package s30.dp;

public class numDistincts {
    public int numDistinct(String s, String t) {
        Integer[][] memo = new Integer[t.length()][s.length()];
        return helper(s,t,0,0,memo);
    }

    private int helper(String s, String t, int i, int j, Integer[][] memo) {
        //base case: form entire target string
        if (i==t.length()) {
            return 1; //found one valid subsequence
        }
        if (j==s.length()) {
            return 0;
        }
        //check memo
        if (memo[i][j]!=null) {
            return memo[i][j];
        }
        int ways=0;
        //if characters match ; we have 2 choices
        if (s.charAt(j)==t.charAt(i)) {
            //choose
            ways+=helper(s,t,i+1,j+1,memo);
            //not choose
            ways+=helper(s,t,i,j+1,memo);
        }
        else {
            ways=helper(s,t,i,j+1,memo);
        }
        memo[i][j]= ways;
        return ways;
    }
}
