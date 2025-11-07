package stripe;

import java.util.LinkedList;
import java.util.Queue;

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
    //bfs
    public int numIslandsbfs(char[][] grid) {
        if (grid==null || grid.length==0){return 0;}
        int count=0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='1'){
                    count++;
                    grid[i][j] = '0';
                    Queue<int[]> q = new LinkedList<int[]>();
                    q.offer(new int[]{i,j});
                    while (!q.isEmpty()){
                        int[] curr = q.poll();
                        for (int[] dir : dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c]=='1'){
                                grid[r][c] = '0';
                                q.offer(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}
