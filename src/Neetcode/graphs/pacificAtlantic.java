package Neetcode.graphs;

import java.util.*;

public class pacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights == null || heights.length == 0) return ans;

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // add pacific borders to queue
        for (int col=0; col<cols; col++) {
            pacificQueue.offer(new int[]{0, col});
            pacific[0][col] = true;
        }
        for (int row=1  ; row<rows; row++) { //start from 1 to avoid duplication
            pacificQueue.offer(new int[]{row, 0});
            pacific[row][0] = true;
        }

        // add atlantic borders to queue
        for (int col=0; col<cols; col++) {
            atlanticQueue.offer(new int[]{rows-1, col});
            atlantic[rows-1][col] = true;
        }
        for (int row=0  ; row<rows-1; row++) {
            atlanticQueue.offer(new int[]{row, cols-1});
            atlantic[row][cols-1] = true;
        }

        //bfs from both queues
        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        //find interaction
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    ans.add(Arrays.asList(row, col));
                }
            }
        }
        return ans;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];
            for (int[] dir : dirs) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && !visited[newRow][newCol]
                        && heights[newRow][newCol] >= heights[row][col]) {  // Flow upward!
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }


}
