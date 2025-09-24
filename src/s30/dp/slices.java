package s30.dp;

public class slices {

    //brute force: TC= O(n^2) ; SC=O(1)
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int n=nums.length;
        for (int i = 0; i < n-2; i++) {
            int diff = nums[i+1]-nums[i];
            for (int j = i+2; j < n; j++) {
                if (nums[j]-nums[j-1]==diff)
                    count++;
                else{break;}
            }
        }
        return count;
    }

    //Optimized Solution: O(n) ; SC=O(1)
    public int numberOfArithmeticSlices1(int[] nums) {
        int count = 0;
        int n = nums.length;
        int prev=0, curr=0;
        if (n<3){return 0;}
        for (int i = 2; i < n; i++) {
            if(nums[i-1]-nums[i-2] ==nums[i]-nums[i-1])
            {
                curr=prev+1;
            }
            else {
                curr=0;
            }

            prev=curr;
        }
        return count;
    }
}
