public class bloomDay {
    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 5, 5, 5, 10, 5, 5};

        int ans = solve(2,3,arr1 );
        System.out.println(ans);
    }
    public static int solve(int M, int K, int[] bloomDay) {
        if(bloomDay.length<M*K)
        {
            return -1;
        }
        int max=Integer.MIN_VALUE;
        for(int i:bloomDay)
        {
            max=Math.max(max,i);
        }
        int res=-1;
        int low=1,high=max;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int sum=0,b=0;
            for(int i=0;i<bloomDay.length;i++)
            {
                if(bloomDay[i]<=mid)
                {
                    sum++;
                }
                else
                {
                    sum=0;
                }
                if(sum==K)
                {
                    b++;
                    sum=0;
                }
            }
            if(b>=M)
            {
                res=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return res;
    }
}
