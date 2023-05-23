package stacksqueues.pretopost;

import java.util.Stack;

public class pretopost {

    public static void main(String[] args) {

        // int[] arr = new int[]{10, 5, 2, 7, 1, 9};
        String res= pretopost("*-A/BC-/AKL");
        System.out.println(res);
    }
public static String pretopost(String str)
{
    String res= "";
    Stack<String> stack= new Stack<>();

    for(int i=str.length()-1;i>=0;i--)
    {
        res+= str.charAt(i);
    }

    for(int i=0;i<res.length();i++)
    {
        char ch= res.charAt(i);
        if(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
        {
            stack.push(ch+"");
        }
        else if((ch=='/'||ch=='*'|| ch=='+' || ch=='-' || ch=='^')&& stack.size()>=1)
        {

            String op1= stack.pop();
            String op2= stack.pop();

            String rs= op1+op2+ch;
            stack.push(rs);
        }

    }
    return stack.peek();
}


}
