package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class parityeo {
    public static int[] sortArrayByParityII(int[] nums) {
        ArrayList<Integer> evenNos= new ArrayList<>();
        ArrayList<Integer> oddNos= new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                evenNos.add(nums[i]);
            }
            else
            {
                oddNos.add(nums[i]);
            }
        }
        int j=0;
        for(int i=0;i<evenNos.size();i++)
        {
            nums[j]= evenNos.get(i);
            j+=2;
            //    i++;
        }
        int k=1;
        for(int i=0;i<oddNos.size();i++)
        {
            nums[k]= oddNos.get(i);
            k+=2;
            //    i++;
        }
        return nums;
    }

    public static void main(String[] args)
    {
        int [] A= new int[]{4,2,5,7};
        int[] B= new int[]{2,3};

        int res[]=sortArrayByParityII(A);

        System.out.println(Arrays.toString(res));
    }

}
