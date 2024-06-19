package searching;

public class NthRoot {
    public class Solution {
        public  int NthRoot(int n, int m) {
            // Write your code here.
            int res = -1;
            double powerRes = Math.pow(m, 1.0 / n);

            // Define a small tolerance for floating-point comparison
            double tolerance = 1e-10;

            // Check if powerRes is close enough to an integer
            if (Math.abs(powerRes - Math.round(powerRes)) < tolerance) {
                res = (int) Math.round(powerRes);
            }

            return res;
        }
    }

}
