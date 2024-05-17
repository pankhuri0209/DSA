package striver;

import java.util.Arrays;
import java.util.HashSet;

//better
public class longestSuccElements {

    public static int lcs(int[] a)
    {
      //  int res=0;
        Arrays.sort(a);
        int lastSmaller= Integer.MIN_VALUE;
        int cnt=0;
        int longest=1;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]-1 == lastSmaller)
            {
                cnt++;
                lastSmaller=a[i];
            } else if (a[i]-1!=lastSmaller) {
                cnt=1;
                lastSmaller=a[i];
            }
            longest= Math.max(cnt,longest);
        }

        return longest;
    }

    public static int lcs1(int[] a)
    {
        if(a.length==0)
        {
            return 0;
        }
        int longest=1;
        HashSet<Integer> set= new HashSet<>();
        for(int i: a)
        {
            set.add(i);
        }
        for(int it:a)
        {
            if(!set.contains(it-1)) {
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x=x+1;
                    cnt++;

                }
                longest=Math.max(longest,cnt);
            }
        }

        return longest;
    }


    public static void main(String[] args)
    {

        int [] A= new int[]{100,4,200,1,3,2};

        int res=  lcs(A);
        System.out.println(res);

        //optimal
        int res1=  lcs1(A);
        System.out.println(res1);

    }

}
