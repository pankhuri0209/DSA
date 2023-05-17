package stacksqueues.infixTopostfix;
import java.util.Stack;

public class infixtopostfix {
    public static String infixTopostfix(String exp)
    {
        Stack<String> opnd= new Stack<>();
        Stack<Character> ops= new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch = exp.charAt(i);
            if(ch=='(')
            {
                ops.push(ch);
            }
            else if(ch==')')
            {
                while (ops.size()>0 && ops.peek()!='(' && precedence(ch) <= precedence(ops.peek()))
                {
                    String s2= opnd.pop();
                    String s1= opnd.pop();
                    char op= ops.pop();
                    String res= s1+s2+op;
                    opnd.push(res);
                }
                ops.pop();
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^')
            {
                while (ops.size()>0 && ops.peek()!='(' && precedence(ch) <=precedence(ops.peek()))
                {
                    String s2= opnd.pop();
                    String s1= opnd.pop();
                    char op= ops.pop();
                    String res= s1+s2+op;
                    opnd.push(res);
                    ops.push(ch);
                }
            }
            else {
                opnd.push(ch+"");
            }
        }
        while(ops.size()>0)
        {
            String s2=opnd.pop();
            String s1=opnd.pop();
            char op=ops.pop();
            String res=s1+s2+op;
            opnd.push(res);
        }
        return opnd.peek();
    }

    public static int precedence(char ch)
    {
        if(ch=='+'){return 1;}
        else if(ch=='-'){return 2;}
        else if(ch=='*'){return 3;}
        else if(ch=='/'){return 4;}
        return 0;
    }
}
