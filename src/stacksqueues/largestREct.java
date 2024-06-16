package stacksqueues;

import java.util.Stack;

public class largestREct {
        public static int largestRectangleArea(int[] heights) {
            int maxAns = 0;
            int[] ps = prevSmaller(heights);
            int[] ns = nextSmaller(heights);

            for (int i = 0; i < heights.length; i++) {
                int curr = (ns[i] - ps[i] - 1) * heights[i];
                maxAns = Math.max(maxAns, curr);
            }
            return maxAns;
        }

        public static int[] prevSmaller(int[] a) {
            int[] ps = new int[a.length];
            Stack<Integer> s = new Stack<>();

            for (int i = 0; i < a.length; i++) {
                while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    ps[i] = -1;
                } else {
                    ps[i] = s.peek();
                }
                s.push(i);
            }
            return ps;
        }

        public static int[] nextSmaller(int[] a) {
            int[] ns = new int[a.length];
            Stack<Integer> s = new Stack<>();

            for (int i = a.length - 1; i >= 0; i--) {
                while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    ns[i] = a.length;
                } else {
                    ns[i] = s.peek();
                }
                s.push(i);
            }
            return ns;
        }

        public static void main(String[] args) {
           // Solution sol = new Solution();
            int[] heights = {2, 1, 5, 6, 2, 3};
            System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
        }


}
