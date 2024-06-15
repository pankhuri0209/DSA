package striver.stackqueues;

import java.util.Stack;

public class sortStack {


    public class Solution {

        // Main function to sort the stack
        public  void sortStack(Stack<Integer> stack) {
            // Base case: if the stack is empty, return
            if(stack.size() == 0) {
                return;
            }

            // Remove the top element
            int temp = stack.pop();

            // Recursively sort the remaining stack
            sortStack(stack);

            // Insert the removed element back into the sorted stack
            insertSorted(temp, stack);
        }

        // Helper function to insert an element into a sorted stack
        public  void insertSorted(int curr, Stack<Integer> stack) {
            // Base case: if the stack is empty or the top element is less than the current element
            if(stack.empty() || stack.peek() < curr) {
                stack.push(curr);
                return;
            }

            // Remove the top element
            int temp = stack.pop();

            // Recursively insert the current element into the sorted stack
            insertSorted(curr, stack);

            // Push the removed element back onto the stack
            stack.push(temp);
        }
    }

}
