package stacksqueues.nextGreater;

import java.util.Arrays;
import java.util.Stack;

public class nextGreater {
    public static void main(String[] args) {
         int[] arr = new int[]{5,4,3,2,1};
         System.out.println(Arrays.toString(nextLargerElement(arr,5)));
    }

    public static int[] nextLargerElement(int[] arr, int n) {
        int[] ans = new int[arr.length];
        Stack<Integer>stack=new Stack<>();
        for(int i =2*arr.length-1;i>=0;i--)
        {
            while(!stack.isEmpty() && stack.peek()<=arr[i%arr.length])
            {
                stack.pop();
            }
            if(i<arr.length)
            {
                if(stack.isEmpty() ==  false)
                    ans[i] = stack.peek();
                else
                    ans[i] = -1;
            }
            stack.push(arr[i%arr.length]);
        }
        return ans;
    }

}
