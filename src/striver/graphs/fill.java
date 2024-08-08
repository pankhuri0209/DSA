package striver.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class fill {
    static void solve(char[][] board)
    {
        if(board ==null || board.length==0)
        {
            return;
        }
        int m= board.length;
        int n= board[0].length;

        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O'){bfs(board, i,0);}
            if(board[i][n-1] =='O'){bfs(board, i, n-1);}
        }
        for(int j=0;j<n;j++)
        {
            if(board[0][j] =='O'){bfs(board, 0,j);}
            if(board[m-1][j]=='O'){bfs(board, m-1, j);}
        }

        //step2
        for(int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if(board[i][j] =='O')
                {
                    board[i][j]='X';
                }

            }
        }

        for(int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if(board[i][j]=='E')
                {
                    board[i][j]='O';
                }
            }
        }
    }

    private static void bfs(char[][] board, int i, int j )
    {
        int m= board.length;
        int n= board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        board[i][j]='E'; // mark as visited and non-capturable

        int[][] directions= {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty())
        {
            int[] curr= queue.poll();
            for(int[] dir: directions)
            {
                int x= curr[0] + dir[0];
                int y= curr[1] + dir[1];
                if(x>=0 && x<m && y>=0 && y<n && board[x][y]=='O')
                {
                    board[x][y] = 'E';
                    queue.offer(new int[]{x,y});
                }
            }
        }
    }
}
