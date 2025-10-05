package s30.dp;

public class minDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i=0;i<=m;i++){
            dp[i][0] = i;
        }
        //base case: converting empty string to word2 would require j operations
        for (int j=0;j<=n;j++){
            dp[0][j] = j;
        }

        //fill the dp table
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }

                else{
                    //take min of 3 operations
                    dp[i][j]= 1+ Math.min(
                            dp[i-1][j],  //delete from word1
                            Math.min(dp[i][j-1], //insert into word1
                                    dp[i-1][j-1]) //replace in word1
                    );
                }
            }
        }
        return dp[m][n];
    }
}
