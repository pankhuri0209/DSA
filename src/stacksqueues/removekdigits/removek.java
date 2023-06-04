package stacksqueues.removekdigits;

import java.util.Arrays;
import java.util.Stack;

public class removek {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,-3};
        System.out.println((removeKdigitsstack("91009",1)));
    }

    //stacks
    public static String removeKdigitsstack(String S, int K) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < S.length(); i++) {// looping to fill stack and keeping the highest element on top
            int digit = S.charAt(i) - '0';
            while (!st.isEmpty() && digit < st.peek() && K > 0) {// to pop: stack should not be empty and k>0
                st.pop();               // main condition to remove : peeked element is greater than digit
                K--;
            }
            st.push(digit);             //push every element of the string
        }
        while (K > 0 && !st.isEmpty()) { //if k!=0 and stack not empty
            st.pop();       ///pop the element
            K--;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());    // append in the stringbuilder
        }
        String ans = sb.reverse().toString(); // reverse
        while (ans.length() > 1 && ans.charAt(0) == '0') { //ans should be >1 and 1st element is 0
            ans = ans.substring(1);
        }
        return ans;



    }



    //arays
    public String removeKdigits(String num, int k) {
        // code here

        int digits=num.length()-k;
        if(num.length()<=k){return "0";}
        String ans="";
        int top=-1, start=0;
        char[] st= num.toCharArray();

        for(int i=0;i<st.length;i++)
        {
            while( top>=0 && st[top]>st[i] && k>0)
            {
                top--;
                k--;
            }
            top++;
            st[top]= st[i];
        }
        while( start<=top && st[start]=='0')
        {
            start++;
        }
        for(int i=start;i<digits;i++)
        {
            ans+=st[i];
        }
        if(ans.equals(""))
        {return "";}
        return ans;
    }
}
