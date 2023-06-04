package stacksqueues.largestRect;

import java.util.Stack;

public class largestRect {
    public static void main(String[] args) {
    //    int[] arr = new int[]{3,2,5,6,2,3};
        int[] arr = new int[]{6,2,5,4,5,1,6};
        System.out.println((largestRect(arr, arr.length)));
    }

    //stacks
    public static int largestRect(int hist[], int n) {

        Stack<Integer> st= new Stack<>();
        int maxA=0;

        for (int i=0;i<=n;i++)
        {
            while (!st.isEmpty() && (i==n || hist[st.peek()] >=hist[i]))
            {
                int height= hist[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){width=i;}
                else {width=i-st.peek()-1;}
                maxA= Math.max(maxA,width*height);
            }
            st.push(i);
        }

        return maxA;
    }
}
