package leetcode;

import java.util.Arrays;

public class MeetingRoom {



//        public static boolean canAttendMeetings(Interval[] intervals) {
//
//            Arrays.sort(intervals, (a, b) -> a.start - b.start);
//
//            for(int i = 0; i + 1 < intervals.length; i++){
//
//                if(intervals[i].end > intervals[i + 1].start){
//                    return false;
//                }
//            }
//
//            return true;
//        }
//
//    public class Interval {
//        int start;
//        int end;
//
//    }
//    public static void main(String[] args)
//    {
//        int[] arr= {6,3,9,5,2,8};
//        int n= arr.length;
//
//        int[][] twoDArray = {{0, 30}, {5, 10}, {15, 20}};
//       // canAttendMeetings(twoDArray);
//        System.out.println(Arrays.toString(arr));
//    }

    public static boolean canAttend(int[][] intervals){
        if(intervals == null || intervals.length == 0) return true;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i - 1][1])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] t = {{0, 3}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings1(t));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        int len = intervals.length;
        int[] startTime = new int[len];
        int[] endTime = new int[len];
        int count = 0;
        for(int[] interval: intervals){
            startTime[count] = interval[0];
            endTime[count++] = interval[1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        for(int i = 1; i < len; i++){
            if(startTime[i] < endTime[i - 1]) return false;
        }
        return true;
    }
    public static boolean canAttendMeetings1(int[][] intervals) {
        if(intervals == null) return false;
        if(intervals.length == 0) return true;
        Arrays.sort(intervals, (a, b)->{
            return a[0] == b[0] ? a[1] - b[1]: a[0] - b[0];
        });
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }
}

