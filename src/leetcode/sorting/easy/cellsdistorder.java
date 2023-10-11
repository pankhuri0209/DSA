package leetcode.sorting.easy;

import java.util.Arrays;

public class cellsdistorder {

    public int[][] allCellsDistOrder(int R,int C, int r0, int c0)
    {
        int[][]ans = new int[R*C][2];

        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                int bno= i*C+j;
                ans[bno][0]=i;
                ans[bno][1]=j;
            }
        }
        Arrays.sort(ans, (a,b) ->{
            int d1= Math.abs(a[0] -r0) +Math.abs(a[1]- c0);
            int d2= Math.abs(b[0] - r0) +Math.abs(a[1]-c0);
            return d1-d2;
        });
        return  ans;
    }
}
