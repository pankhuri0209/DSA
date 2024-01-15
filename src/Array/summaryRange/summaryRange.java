package Array.summaryRange;

import java.util.ArrayList;
import java.util.List;

public class summaryRange {
    public static List<String> summaryRange(int[] nums)
    {
        List<String> list= new ArrayList<>();
        int n= nums.length;

        for(int i=0;i<n;i++)
        {
            int start= nums[i];
            while(i+1<n && nums[i+1]==nums[i]+1)
            {
                i++;
            }
            if(start!=nums[i])
            {
                list.add(" "+start+"->"+ nums[i]);
            }
            else {
                list.add(""+start);
            }
        }
        System.out.println(list);

        return list;
    }
    public static void main(String[] args)
    {
      //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{0,2,3,4,6,8,9};
        // String[] B= new String[]{"story","fleet","leetcode"};

        summaryRange(A);

        //  System.out.println(res);
    }
}
