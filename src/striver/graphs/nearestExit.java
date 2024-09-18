package striver.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class nearestExit {

    public int nearestExit(char[][] maze, int[] entrance)
    {
        int m= maze.length;
        int n= maze[0].length;

        // directions
        int[] drow= {-1,0,+1,0};
        int[] dcol= {0,+1,0,-1};

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{entrance[0], entrance[1],0});

        //mark the entrance as visited
        maze[entrance[0]][entrance[1]] ='+';

        while(!queue.isEmpty())
        {
            int[] current= queue.poll();
            int row= current[0];
            int col= current[1];
            int steps= current[2];

            for (int i=0;i<4;i++)
            {
                int newRow= row+drow[i];
                int newCol= col+ dcol[i];

                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && maze[newRow][newCol]=='.')
                {
                    if(newRow==0 || newRow ==m-1  || newCol==0 || newCol ==n-1)
                    {
                        return steps+1;
                    }
                        maze[newRow][newCol]='+';
                        queue.add(new int[]{newRow,newCol,steps+1});

                }
            }
        }
        return -1;
    }

}
