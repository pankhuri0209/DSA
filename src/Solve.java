class Pair
{
    int floor,ceil;
    Pair(int floor, int ceil)
    {
        this.floor= floor;
        this.ceil= ceil;
    }
}

class Solve {
    public static   void main(String[] args)
    {
        int[] arr= new int[]{5, 6, 8, 9, 6, 5, 5, 6 };
        // long ans= maxProduct(arr,arr.length);
        Pair pair= getFloorAndCeil(arr,arr.length,7);
        System.out.println(pair.floor +" "+pair.ceil);
    }
    static Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here
        int floor=Integer.MIN_VALUE;
        int ceil=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<=x && arr[i]>floor)
            {
                floor=arr[i];
            }
            if(arr[i]>=x && arr[i]<ceil)
            {
                ceil=arr[i];
            }
        }
        return new Pair(Integer.MIN_VALUE==floor? -1 :floor, Integer.MAX_VALUE==ceil?-1 : ceil);
    }
}
