package stacksqueues.postToinfix;

import java.util.Stack;

public class postToinfix {
    public static void main(String[] args) {

        // int[] arr = new int[]{10, 5, 2, 7, 1, 9};
        String res= postToInfix("ab*c+");
        System.out.println(res);
    }

    static String postToInfix(String exp) {
        // code here
        Stack<String> stack= new Stack<>();

        for(int i=0;i<exp.length();i++)
        {
            char ch= exp.charAt(i);
            if(ch>='A' && ch<='Z' || ch>='a'&& ch<='z' )
            {
                stack.push(ch+"");
            }
            else if((ch=='/'||ch=='*'|| ch=='+' || ch=='-' || ch=='^')&& stack.size()>=1)
            {
                String op2 = stack.pop();
                String op1= stack.pop();

                if(op1.length()>1 && op2.length()>1)
                {
                    stack.push("("+op1+")"+ch+"("+op2+")");
                }
                else if(op1.length()>1)
                {
                    stack.push("("+op1+")"+ch+op2);
                }
                else if(op2.length()>1)
                {
                    stack.push(op1+ch+"("+op2+")");
                }
                else
                {
                    stack.push(op1+ch+op2);
                }

            }

        }
        return "("+stack.peek()+")";
    }
}
