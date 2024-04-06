package striver;

import java.util.ArrayList;
import java.util.HashSet;

public class longestConsq {

    public static int longestCon(int[] nums){

        int max_sequence_length=0;

        for(int i=0;i<nums.length;i++)
        {
            int current_sum= nums[i];
            int current_seq_length=1;

            while(numberExist(nums,current_sum+1))
            {
                current_sum+=1;
                current_seq_length+=1;
            }
            max_sequence_length =Math.max(max_sequence_length,current_seq_length);
        }


        return max_sequence_length;
    }
    public static boolean  numberExist(int[] nums, int isNo){

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==isNo)
            {
                return true;
            }

        }
        return false;
    }


    public static int longestConOpt(int[] nums){

        int max_sequence_length=0;

        HashSet<Integer> num_set= new HashSet<>();

        for(int num:nums)
        {
            num_set.add(num);
        }

        for (int i=0;i<nums.length;i++)
        {
            int current_num = nums[i];
            int current_seq_length=1;

            if(!num_set.contains(current_num-1))
            {
                while (num_set.contains(current_num+1))
                {
                    current_num+=1;
                    current_seq_length+=1;
                }
                max_sequence_length = Math.max(max_sequence_length,current_seq_length);
            }
        }
        return max_sequence_length;
    }

    public static void main(String[] args)
    {
        //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{100,4,200,1,3,2};
        // String[] B= new String[]{"story","fleet","leetcode"};
//        String[] a= new String[]{"k","KFC"};
//        String[] b= new String[]{"k","KFC"};
       System.out.println(longestConOpt(A));
       /// lis.stream().forEach(System.out::println);

//        for(int i=0;i<A.length;i++)
//        {
//            System.out.println(A[i]);
//        }

        //  System.out.println(findRestaurant(a,b));

        //  System.out.println(res);
    }


}
