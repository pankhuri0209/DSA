package striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeoverlappingintervals {
    public int[][] merge(int[][] intervals) {

        int n= intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }

        });

        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size()-1).get(1))
            {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            else
            {
                ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1), intervals[i][1]));
            }
        }

        int rows = ans.size();
        int cols= ans.get(0).size();
        int[][] res= new int[rows][cols];

        for(int i=0;i<rows;i++)
        {
            List<Integer> rowslist= ans.get(i);
            for(int j=0;j<cols;j++)
            {
                res[i][j]=rowslist.get(j);
            }
        }

        return res;
    }
}
