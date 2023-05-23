package stacksqueues.nextGreater;

import java.util.Arrays;
import java.util.Stack;

public class nextGreater {
    public static void main(String[] args) {

         long[] arr = new long[]{1 ,3, 2, 4};

        //System.out.println(res);
        System.out.println(Arrays.toString(nextLargerElement(arr,4)));
    }
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        Stack<Long> stack= new Stack<>();
        long[] res = new long[arr.length];
        int j=0;
        long top=0;
        Arrays.fill(res, -1);
        boolean flag =false;
        for(int i=0;i<arr.length-1;i++)
        {
            j=i+1;
            long curr= arr[i];
            long next= arr[j];
            while(curr>next && j<arr.length)
            //if(curr<next)
            {
                flag=true;
                next=arr[j++];
                // stack.push(next);
            }
            if(flag==true || next>curr)
            {stack.push(next);}
            flag=false;
        }
        int k=0;
        if(stack.size()>1)
        {
            for(int i=stack.size()-1;i>=0;i--)
            {
                res[i]=stack.pop();
            }
        }
        return res;
    }
}
