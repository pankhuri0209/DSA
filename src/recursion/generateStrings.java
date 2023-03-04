package recursion;

import java.util.ArrayList;
import java.util.List;

public class generateStrings {
    public static void main(String[] args)
    {
        String S="-12";
         generateBinaryStrings(3);
       // System.out.printf(String.valueOf(ans));
    }
    public static List<String> generateBinaryStrings(int n) {
        ArrayList<String> list = new ArrayList<String>();
        recur(n, list, "");
        return list;
    }
    public static void recur(int n, List<String> list, String str)
    {
        if(str.length() == n)
        {
            list.add(str);
            return;
        }
        recur(n, list, str + '0');
        if(str.length() > 0 && str.charAt(str.length() - 1) != '1')
        {
            recur(n, list, str + '1');
        }
        if(str.length() == 0)
        {
            recur(n, list, str + '1');
        }
    }
}
