package bitsManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class possibleSubseq {
    public static List<String> AllPossibleStrings(String s)
    {
        // Code here
        ArrayList<String> ans= new ArrayList<>();
        findSubset(s,"",ans,0);
        Collections.sort(ans);
        return ans;
    }
    public static void findSubset(String str, String temp, ArrayList<String> ans, int i)

    {
        //base case
        if(i == str.length())
        {
            if(temp.length()!=0)
            {
                ans.add(temp);
            }
            return;
        }
        findSubset(str,temp+str.charAt(i), ans,i+1);
        findSubset(str,temp,ans,i+1);
    }
    public static void main(String[] args) {

        AllPossibleStrings("aa");
    }
}
