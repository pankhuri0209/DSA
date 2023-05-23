package stacksqueues.preToInfix;

import java.util.Stack;



public class preToInfix {

    public static void main(String[] args) {

       // int[] arr = new int[]{10, 5, 2, 7, 1, 9};
       String res= preToInfix("+ab");
       System.out.println(res);
    }

    static String preToInfix(String str) {
        // code here
        Stack<String> stack=new Stack<>();
        String res="", ans="";
        for(int i=str.length()-1;i>=0;i--)
        {
            res+=str.charAt(i);

        }
        for(int i=0;i<res.length();i++)
        {
            char ch= res.charAt(i);
            if(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
            {
                stack.push(ch+"");

            }
            else if(ch=='/'||ch=='*'|| ch=='+' || ch=='-' || ch=='^')
            {
                String op1= stack.pop();
                String op2= stack.pop();
                if(op1.length()>2 && op2.length()>2){
                    stack.push("("+op1+")"+ch+"("+op2+")");
                }
                else if(op1.length()>2){
                    stack.push("("+op1+")"+ch+op2);
                }
                else if(op2.length()>2){
                    stack.push(op1+ch+"("+op2+")");
                }
                else
                {
                    stack.push(op1+ch+op2);
                }

            }
        }



        return stack.peek();

    }



}
