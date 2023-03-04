import java.util.Arrays;

public class agressiveCows {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1 ,2 ,4 ,8,9};
        int[] nums= new int[]{1,2,3,4,5};
        int[] arr = new int[]{1 ,2 ,1};
        int ans = solve(5,2,arr1);
        System.out.println(ans);
//        int chunk = 2; // chunk size to divide
//        for(int i=0;i<arr1.length;i+=chunk){
//            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, Math.min(nums.length,i+chunk))));
//        }
    }
    public static int solve(int n, int k, int[] stalls) {

        Arrays.sort(stalls);
        int low=1;
        int high= stalls[n-1]-stalls[0];
        int res=-1;
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            if(canPlaceCows(stalls,n,k,mid))
            {
                res= mid;
                low= mid+1;
            }
            else
            {
                high= mid-1;
            }


        }
        return res;

    }
    public static boolean canPlaceCows(int[] stalls, int n, int k, int mid)
    {
        int coord= stalls[0];
        int cnt=1;
        for(int i=1;i<n;i++)
        {
            if(stalls[i]- coord>=mid)
            {
                cnt++;
                coord=stalls[i];
            }

        }
        if(k==cnt)
        {
            return true;
        }
        return false;
    }
}
