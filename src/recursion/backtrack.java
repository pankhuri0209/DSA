package recursion;

import java.util.ArrayList;
import java.util.List;

public class backtrack {

    public static void main(String[] args)
    {
        String S="-12";
        AllParenthesis(2);
        // System.out.printf(String.valueOf(ans));
    }
    public static void backtrack(List<String> list,String str,int open,int close,int max){

        if(str.length()==max*2){

            list.add(str);

            return;

        }

        if(open<max){

            backtrack(list,str+"(",open+1,close,max);

        }

        if(close<open){

            backtrack(list,str+")",open,close+1,max);

        }

    }

    public static List<String> AllParenthesis(int n)

    {

        // Write your code here

        List<String> list=new ArrayList<>();

        backtrack(list,"",0,0,n);

        return list;

    }
}
