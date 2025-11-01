package stripe;

public class numIsIslands {
    //dfs
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid==null || grid.length==0){return 0;}
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        //base case
        if (i<0  || i> grid.length || j<0 || j>grid[0].length || grid[i][j]=='0'){return;}

        //mark the current cell as visited
        grid[i][j] = '0';

        //explore neighbors
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
