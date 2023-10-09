package leetcode;

import java.util.Arrays;

public class finderror {

    public static int[] findErrorNums(int[] nums) {
        int[] arr=new int[nums.length];
        int[] result=new int[2];

        for(int i:nums){
            arr[i-1]++;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]==2){
                result[0]=i+1;
            }
            if(arr[i]==0){
                result[1]=i+1;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        // int [] arr= new int[]{44,22,55,11,66};
     //   int[] arr= new int[]{3,2,3,4};
        int[] arr= new int[]{2,3,4,5,3};
        int res[]=findErrorNums(arr);

        System.out.println(Arrays.toString(res));
    }
}
