package leetcode.sorting.easy;

import java.util.Arrays;

public class perimeterTriangle {
    public static int largestPerimeter(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        for (int k = n - 1; k >= 2; k--) {
            int c = nums[k];
            int b = nums[k - 1];
            int a = nums[k - 2];

            if (isValid(a, b, c)) {
                return a + b + c;
            }
        }

        return 0;
    }

    private static boolean isValid(int a, int b, int c) {
        return a + b > c;
    }
    public static void main(String[] args)
    {
        int [] A= new int[]{1,2,1,10};
        int[] B= new int[]{2,3};

        int res=largestPerimeter(A);

        System.out.println(res);
    }
}
