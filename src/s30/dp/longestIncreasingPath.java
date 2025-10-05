package s30.dp;

public class longestIncreasingPath {
    private int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix){
        if(matrix.length==0 || matrix==null) return 0;

        int  row = matrix.length;
        int col = matrix[0].length;

        int[][] memo = new int[row][col];

        int maxLen=1;

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                maxLen= Math.max(maxLen, dfs(matrix, i,j, memo));
            }
        }
        return maxLen;
    }
    private int dfs(int[][] matrix, int row, int col, int[][] memo){
        if (memo[row][col]!=0) return memo[row][col];

        int maxPath=1;

        //explore all directions
        for (int[] dir:dirs){
            int newRow= row+dir[0];
            int newCol= col+dir[1];
            if (newRow>=0 && newRow<row && newCol>=0 && newCol<col && matrix[newRow][newCol]>matrix[row][col]){
                    int pathLen= 1+dfs(matrix, newRow, newCol, memo);
                    maxPath= Math.max(maxPath, pathLen);
            }
        }
        memo[row][col]=maxPath;
        return maxPath;
    }
}
