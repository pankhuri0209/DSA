package Neetcode.graphs;


import java.util.LinkedList;
import java.util.Queue;

// multi-source bfs problem
public class isIslandsTreasure {

    public void islandsAndTreasure(int[][] grid) {
        if (grid==null || grid.length==0)
        {
            return;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount=0;
        // step1: add all treasure chests to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }

            }
        }
        // step2: bfs from all treasure chests simentaneously
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : dirs) {
                //explore all 4 directions
                int newRow= row+dir[0];
                int newCol = col+dir[1];

                //check bounds and land cell
                if (newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && grid[newRow][newCol]==Integer.MAX_VALUE) {
                    grid[newRow][newCol] = grid[row][col]+1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }

        }
    }
    public void islandsAndTreasure1(int[][] grid) {
        if (grid==null || grid.length==0)
        {
            return;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] dir : dirs) {
                int newRow= row+dir[0];
                int newCol = col+dir[1];
                if (newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && grid[newRow][newCol]==Integer.MAX_VALUE) {
                    grid[newRow][newCol] = grid[row][col]+1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

}
