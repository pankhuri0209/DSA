package leetcode;

import java.util.Arrays;

public class cookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count =0;
        int i=0,j=0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                count++;
                i++;
                j++;
            } else{
                j++;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        // int [] arr= new int[]{44,22,55,11,66};
        int res=findContentChildren(new int[]{1,2,3},new int[]{1,2});

        System.out.println(res);
    }

}
