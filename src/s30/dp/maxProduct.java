package s30.dp;

public class maxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxEndingHere= nums[0];
        int minEndingHere= nums[0];
        int result=nums[0];
        for (int i = 1; i < n; i++) {
            int curr= nums[i];
            int tempMax= maxEndingHere;

            maxEndingHere= Math.max(Math.max(curr*maxEndingHere, curr*minEndingHere), curr);
            minEndingHere= Math.min(curr, Math.min(curr*tempMax, curr*minEndingHere)); // -100*100 , -100*-1000
            result= Math.max(result, maxEndingHere);

        }
        return result;

    }

}
