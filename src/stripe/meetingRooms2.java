package stripe;

import java.util.Arrays;
import java.util.PriorityQueue;

public class meetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0)
            return 0;

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++)
        {
            int currStart= intervals[i][0];
            int earliest= pq.peek();
            if(earliest<=intervals[i][1])
            {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
    public int minMeetingRooms1(int[][] intervals) {
        int n=intervals.length;
        if (n==0) return 0;
        int[] start= new int[n];
        int[] end=new int[n];
        for(int i=0;i<n;i++)
        {
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms=0;
        int endPtr=0;
        for(int i=0;i<n;i++)
        {
            if (start[i]<end[endPtr])
            {
                rooms++;
            }
            else {
                endPtr++;
            }
        }
        return rooms;
    }
}
