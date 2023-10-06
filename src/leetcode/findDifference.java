package leetcode;

import java.util.Arrays;

public class findDifference {
    public static char findTheDifference(String s, String t) {
        char [] arr= new char[26];
        char res=' ';
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            int index= c- 'a';
            arr[index]='1';
        }
        for(int i=0;i<t.length();i++)
        {
            char c = t.charAt(i);
            int index= c- 'a';
            arr[index]='2';
        }
        for(int i=0;i<arr.length;i++)
        {
            if (arr[i] == '1')
            {
                res= (char) (i + 'a');
            }

        }
        return res;
    }
    public static char findTheDifference1(String s, String t) {
        char c = 0;
        for(char cs : s.toCharArray()) c ^= cs;
        for(char ct : t.toCharArray()) c ^= ct;
        return c;
    }
    public static void main(String[] args)
    {
       // int [] arr= new int[]{44,22,55,11,66};
        char res=findTheDifference1("abcde","abcd");

        System.out.println(res);
    }

}
