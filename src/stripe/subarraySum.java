package stripe;

import java.util.HashMap;
import java.util.Map;

public class subarraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int num: nums) {
            currSum += num;
            if(map.containsKey(currSum - k)){
                count += map.get(currSum - k);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
