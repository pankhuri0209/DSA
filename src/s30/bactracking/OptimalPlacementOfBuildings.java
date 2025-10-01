package s30.bactracking;

import java.util.LinkedList;
import java.util.Queue;

public class OptimalPlacementOfBuildings {
    public static void main(String[] args) {
        BuildingPlacement buildingPlacement = new BuildingPlacement();
        System.out.println(buildingPlacement.findMinDistance(7, 7, 3));
    }
    public static class BuildingPlacement {
        int H;
        int W;
        int res;

        public int findMinDistance(int h, int w, int n) {
        this.H=h;
        this.W=w;
        this.res= Integer.MAX_VALUE;
        int[][] grid= new int[H][W];
        for(int i=0; i<grid.length;i++)
        {
            for (int j=0; j<grid[0].length;j++)
            {
                grid[i][j]=-1;
            }
        }
        helper(grid, 0, n);
        return res;
        }
        public  void helper(int[][] grid, int pivot, int n)
        {
            // base case
            if(n==0)
            {
                bfs(grid); // calculate min max distance
                return;
            }
            for (int i = pivot; i < this.H*this.W; i++) {
                int r= i/this.W;
                int c= i%this.W;
                //action
                grid[r][c] = 0;
                //recurse
                helper(grid, i + 1, n - 1);
                //bactrack
                grid[r][c] = -1;
            }
        }
        public  void bfs(int[][] grid)
        {
            int m= grid.length;
            int n= grid[0].length;
            int[][] dirs= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
            Queue<int[]> q= new LinkedList<>();
            boolean[][] visited= new boolean[H][W];
            for (int i=0; i<m;i++)
            {
                for (int j=0; j<n;j++)
                {
                    if (grid[i][j]==0)
                    {
                        q.add(new int[] {i,j});
                        visited[i][j]=true;
                    }
                }
            }
            int dist=0;
            while(!q.isEmpty())
            {
                int size = q.size();
                for (int i=0; i<size; i++)
                {
                    int[] curr = q.poll();
                    for (int[] dir: dirs)
                    {
                        int r= curr[0]+dir[0];
                        int c= curr[1]+dir[1];

                        if (r>=0 && c>=0 && r<H && c<W && !visited[r][c] && grid[r][c]==-1)
                        {
                            q.add(new int[] {r,c});
                            visited[r][c]=true;
                        }
                    }
                }
                dist++;
            }
            res= Math.min(res,dist-1);
        }
    }

}
