import java.util.Arrays;

public class agressiveCowsBT {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1 ,2 ,4 ,8,9};
        int[] nums= new int[]{1,2,3,4,5};
        int[] arr = new int[]{1 ,2 ,1};
        int ans = solve(5,3,arr1);
        System.out.println(ans);
//        int chunk = 2; // chunk size to divide
//        for(int i=0;i<arr1.length;i+=chunk){
//            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, Math.min(nums.length,i+chunk))));
//        }
    }
    public static int solve(int n, int k, int[] stalls) {

        Arrays.sort(stalls);
        int maxD= stalls[n-1]-stalls[0];
        int res= Integer.MIN_VALUE;
        for(int i=1;i<=maxD;i++)
        {
            if(isCompatible(stalls,n,k,i))
            {
                res= Math.max(res,i);
            }
        }
        return res;

    }

    static boolean isCompatible(int[] stalls, int n, int k, int maxD)
    {
        int pl= stalls[0];
        k--;
        for(int i=1;i<n;i++)
        {
            if(stalls[i]-pl >=maxD)
            {
                k--;
            }

            if(k==0)
            {
                return true;
            }
            pl= stalls[i];
        }
        return false;
    }
}
