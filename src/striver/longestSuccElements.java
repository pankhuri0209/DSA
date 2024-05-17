package striver;

import java.util.Arrays;

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

    public static void main(String[] args)
    {

        int [] A= new int[]{100,4,200,1,3,2};

        int res=  lcs(A);
        System.out.println(res);

    }

}
