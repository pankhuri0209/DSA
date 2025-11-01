package stripe;

import java.util.Arrays;

public class findArrows {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        Arrays.sort(points, (a,b)->a[1]-b[1]);

        int arrows=1;
        int end = points[0][1];

        //iterate thru the rest of the ballooons
        for (int i = 1; i < n; i++) {
            if (end < points[i][0]) {
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }
}
