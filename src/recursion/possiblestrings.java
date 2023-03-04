package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class possiblestrings {
    public static void main(String[] args)
    {
        String S="-12";
        AllPossibleStrings("abc");
        // System.out.printf(String.valueOf(ans));
    }
    public static List<String> AllPossibleStrings(String s)

    {

        // Code here

        ArrayList<String> ans = new ArrayList<>();

        findSubset(s,"",ans,0);

        Collections.sort(ans);

        return ans;

    }

    static void findSubset(String str, String tmp, ArrayList<String> ans, int i)

    {

        //base case

        if(i==str.length())

        {

            if(tmp.length()!=0)

            {

                ans.add(tmp);

            }

            return;

        }

        findSubset(str,tmp+str.charAt(i),ans,i+1);

        findSubset(str,tmp,ans,i+1);

    }
}
