package roblox;

import java.util.Arrays;

//https://chatgpt.com/share/fc730ac7-c35a-40d1-9d38-3a5f76a79ca0
public class canPlaceBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);  // Sort the positions array first.

        int low = 1;  // Minimum possible distance.
        int high = position[position.length - 1] - position[0];  // Maximum possible distance.
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceBallsWithGap(position, mid, m)) {
                answer = mid;  // If possible, try to maximize the distance.
                low = mid + 1;
            } else {
                high = mid - 1;  // Otherwise, try smaller distances.
            }
        }

        return answer;
    }
    private boolean canPlaceBallsWithGap(int[] position, int gap, int m) {
        int count = 1;  // Place the first ball at the first position.
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= gap) {
                count++;
                lastPos = position[i];
            }
            if (count == m) {
                return true;  // Successfully placed all m balls.
            }
        }
        return false;  // Not possible to place all m balls with at least 'gap' distance.
    }
}
