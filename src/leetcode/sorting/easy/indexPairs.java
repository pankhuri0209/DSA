package leetcode.sorting.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class indexPairs {

    public static int[][] indexPairs(String text, String [] words)
    {
        List<int[]> res= new ArrayList<>();
        Set<String> set= Arrays.stream(words).collect(Collectors.toSet());

        for(int i=0;i<text.length();i++)
        {
            for(int j=i; j<text.length();j++)
            {
                String substring = text.substring(i,j+1);
                if(set.contains(substring))
                {
                    res.add(new int[]{i,j});
                }
            }
        }
        int[][] ans= new int[res.size()][];
        ans= res.toArray(ans);
        return ans;
    }
    public static void main(String[] args)
    {
        int [] A= new int[]{1,2,1,10};
        String[] B= new String[]{"story","fleet","leetcode"};

        indexPairs("thestoryofleetcodeandme",B);

      //  System.out.println(res);
    }
}
