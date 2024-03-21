package striver;

import java.util.ArrayList;
import java.util.List;

public class majorityElements2 {

    public static List<Integer> majorityElement(int[] nums) {

    int candidate1=Integer.MIN_VALUE, life1=0;
    int candidate2=Integer.MIN_VALUE, life2=0;
    ArrayList<Integer> ans= new ArrayList<>();
    for(int i=0;i<nums.length;i++)
    {
        if(candidate1==nums[i])
        {
            life1++;
        }
        if(candidate2==nums[i])
        {
            life2++;
        }
        else if(life1==0)
        {
            candidate1= nums[i];
            life1=1;
        }
        else if(life2==0)
        {
            candidate2= nums[i];
            life2=1;
        }
        else
        {
            life1--;life2--;
        }

    }
    int count1=0, count2=0;
    int n=nums.length;
    if(candidate1==candidate2)
    {
        ans.add(candidate1);
        return ans;
    }
    for(int i=0;i<nums.length;i++)
    {
        if(candidate1==nums[i]){count1++;}
        if(candidate2==nums[i]){count2++;}

    }

    if(count1>n/3){ans.add(candidate1);}
    if(count2>n/3){ans.add(candidate2);}
    return ans;

}
    public static void main(String[] args)
    {
        //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{1,1,2,3,4,1,1,5,6,7,1,1,8,9,10,1,11,12,13,14};
        // String[] B= new String[]{"story","fleet","leetcode"};
//        String[] a= new String[]{"k","KFC"};
//        String[] b= new String[]{"k","KFC"};
      ArrayList<Integer> lis= (ArrayList<Integer>) majorityElement(A);
      lis.stream().forEach(System.out::println);

//        for(int i=0;i<A.length;i++)
//        {
//            System.out.println(A[i]);
//        }

        //  System.out.println(findRestaurant(a,b));

        //  System.out.println(res);
    }
}
