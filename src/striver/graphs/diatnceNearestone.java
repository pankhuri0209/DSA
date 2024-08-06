package striver.graphs;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class diatnceNearestone {

    class Node{
        int first;
        int second;
        int third;
        Node(int _first, int _second, int _third)
        {
            //this,first = _first;
            this.second = _second;
            this.third= _third;
            this.first = _first;
        }
    }
    public int[][] nearest(int[][] grid)
    {
        int n= grid.length;
        int m= grid[0].length;
        int vis[][] = new int[n][m];
        int dist[][] =  new int[n][m];
        Queue<Node> q = new LinkedList<Node>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
                else {
                    vis[i][j]=0;
                }
            }
        }
        int delrow[] ={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};

        while(!q.isEmpty())
        {
            int row= q.peek().first;
            int col= q.peek().second;
            int steps= q.peek().third;
            q.remove();
            dist[row][col] = steps;
            for(int i=0;i<4;i++)
            {
                int nrow= row+ delrow[i];
                int ncol= col+ delcol[i];

                if(nrow>=0 && nrow<n && ncol >=0 && ncol<n && vis[nrow][ncol]==0)
                {
                    q.add(new Node(nrow, ncol, steps+1));
                }
            }
        }
        return dist;
    }
}
