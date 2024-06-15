package striver.stackqueues;

import java.util.Stack;

public class isValid {
    public boolean isValid(String s) {

        Stack<Character> st= new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' ||  s.charAt(i)=='[')
            {
                st.push(s.charAt(i));
            }
            else
            {
                if(st.isEmpty()) // string starts with closing brackets
                {
                    return false;
                }
                char c= st.peek();
                st.pop();
                if(s.charAt(i)==')' && c=='(' || s.charAt(i)==']' && c=='[' || s.charAt(i)=='}' && c=='{')
                {
                    continue;
                }
                else
                {
                    return false;
                }
            }
        }
        if(st.isEmpty())
        {
            return true;
        }
        return false;



    }
}
