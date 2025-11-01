package stripe;

import java.util.ArrayList;
import java.util.List;

public class insertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res =new ArrayList<int[]>();
        int i=0;
        int n= intervals.length;
        while(i<n && intervals[i][1]<newInterval[0]) //add all intervals that end before the new intervals starts
        {
         res.add(intervals[i]);
         i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]) //merge all overlapping with new intervals
        {
            newInterval[0]= Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]= Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i<n)
        {
            res.add(intervals[i]);
            i++;
        }
        //convert list to 2d
        return res.toArray(new int[res.size()][]);
    }

}
