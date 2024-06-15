package stacksqueues;

import java.util.Stack;

public class longestValidP {
    class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int maxLength = 0;
            stack.push(-1); // Initial base to handle edge case of first valid substring

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i); // Reset the base index for the next valid substring
                    } else {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }
                }
            }

            return maxLength;
        }
    }
}
