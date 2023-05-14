package Array.flips;

public class flips {
    public  static int findZeroes(int arr[], int n, int m) {
        // code here
        int ans=0;
        int len=0;
        int j=-1;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0)
            {
                count++;
            }

            while(count>m)
            {
                j++;

                if(arr[j]==0)
                {
                    count--;
                }

            }

            len=i-j;
            ans= Math.max(len,ans);
        }
        return ans;

    }
    public static void main(String[] args) {

        int[] arr = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        findZeroes(arr,arr.length,2);
    }
}
