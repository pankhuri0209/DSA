package Array;

import java.util.Arrays;

public class singleNumber {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len= nums.length;
        int k=0;
        for(int i=0,c=0; i<len; i+=c  )
        {
            c=0;
            for(int j=i;j<len-1;j++) {
                if(nums[i]!=nums[i+1])
                {
                    break;
                }
                if (nums[i] == nums[j]) {
                    c++;
                }
            }
            if(c==0) {
                k=i;
                return nums[k];
            }
        }
        return nums[k];
    }
    public static void main(String[] args) {
        int[] nums= {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
