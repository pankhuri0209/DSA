package roblox;

import java.util.HashMap;
import java.util.Map;

public class findAllSubarraysWithGivenSum {

    public static int findAll(int[] arr, int k) {
        int n = arr.length; // size of the given array
        Map<Integer, Integer> mpp = new HashMap<>(); // Use generic types
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Initialize map with sum 0 for edge cases

        for (int i = 0; i < n; i++) {
            // Add current element to prefix sum
            preSum += arr[i];

            // Calculate the difference (preSum - k)
            int remove = preSum - k;

            // If the difference exists in the map, add the count to result
            cnt += mpp.getOrDefault(remove, 0);

            // Update the count of the current prefix sum in the map
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;
        System.out.println("Number of subarrays with sum " + k + ": " + findAll(arr, k));
    }
}
