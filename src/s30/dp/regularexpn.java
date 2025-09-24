package s30.dp;

public class regularexpn {

    public boolean isMatch(String s, String p) {

        int m= s.length();
        int n=p.length();
        boolean[][] dp= new boolean[m+1][n+1];
        dp[0][0]=true; //base case

        for (int j=1;j<=n;j++){
            char pChar = p.charAt(j-1);
            if(pChar=='*'){
                dp[0][j] = dp[0][j-2]; //no choose case ; choose not available
            }
        }

        for (int i=1;i<=m;i++){ //default to false ; hence start with 1
            for (int j=1;j<=n;j++){
                char pChar= p.charAt(j-1); //get character
                if (pChar=='*'){
                    if (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2) =='.'){ //previous character match or not
                        dp[i][j]= dp[i][j-2] || dp[i-1][j]; // no choose : skip take 2 steps back ||  choose case : take from above
                    }
                    else {
                        dp[i][j]= dp[i][j-2]; // only 0 occurrence
                    }
                }
                else{ // if not a star ; if it is getting mapped to incoming character
                    if (pChar == s.charAt(i-1) || pChar=='.'){
                        dp[i][j]= dp[i-1][j-1];  // diagnol up left ; means if incoming and current character matches then we have to check the previous match
                    }
                    else{
                        dp[i][j]= false;
                    }
                }
            }
        }
        return dp[m][n];
    }
    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp= new boolean[m+1][n+1];
        dp[0][0]=true;
        for (int j=1;j<=n;j++){
            char pChar = p.charAt(j-1);
            if (pChar=='*'){
                dp[0][j] = dp[0][j-2];
            }
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                char pChar = p.charAt(j-1);
                if (pChar=='*'){
                    if (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2) == '.'){
                        dp[i][j]= dp[i-1][j-2] || dp[i-1][j];
                    }else {
                        dp[i][j]= dp[i-1][j-2];
                    }
                }
                else{
                    if (pChar == s.charAt(i-1) || pChar=='.'){
                        dp[i][j]= dp[i-1][j-1];
                    }
                    else {
                        dp[i][j]= false;
                    }
                }
            }

        }
        return dp[m][n];
    }
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp= new boolean[m+1][n+1];
        dp[0][0]=true;
        for (int j=1;j<=n;j++){
            char pChar = p.charAt(j-1);
            if (pChar=='*'){
                dp[0][j] = dp[0][j-2];
            }
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                char pChar = p.charAt(j-1);
                if (pChar=='*'){
                    if (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2) == '.'){
                        dp[i][j]= dp[i-1][j-2] || dp[i-1][j];
                    }
                    else {
                        dp[i][j]= dp[i-1][j-2];
                    }
                }
                else {
                    if (pChar == s.charAt(i-1) || pChar=='.'){
                        dp[i][j]= dp[i-1][j-1];
                    }
                    else {
                        dp[i][j]=false;
                    }
                }
            }

        }
        return dp[m][n];
    }

    public boolean isMatch3(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp= new boolean[m+1][n+1];
        dp[0][0]=true;
        for (int j=1;j<=n;j++){
        char pChar = p.charAt(j-1);
        if (pChar=='*'){
        dp[0][j] = dp[0][j-2];
            }
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                char pChar = p.charAt(j-1);
                if (pChar=='*'){
                    if (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2) == '.'){
                        dp[i][j]= dp[i-1][j-2] || dp[i-1][j];
                    }
                    else {
                        dp[i][j]= dp[i-1][j-2];
                    }
                }
                else {
                    if (pChar == s.charAt(i-1) || pChar=='.'){
                        dp[i][j]= dp[i-1][j-1];
                    }
                    else {
                        dp[i][j]= false;
                    }
                }
            }
        }
        return dp[m][n];
    }

    }
