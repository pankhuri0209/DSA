package gfg;

public class waveArray {

    public static void convertToWave(int n, int[] a) {
        // code here

        // if(n)

        for(int i=1;i<=n-1;i+=2)
        {
            if(a[i-1]<= a[i] && (i+1)<n && a[i]<=a[i+1])
            {
                int temp=a[i];
                a[i]= a[i-1];
                a[i-1]= temp;
            }
            else if(a[i-1]<= a[i] && (i+1)==n )
            {
                int temp=a[i];
                a[i]= a[i-1];
                a[i-1]= temp;
            }
        }
    }
}
