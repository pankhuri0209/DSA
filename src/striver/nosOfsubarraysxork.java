package striver;

import java.util.HashMap;

public class nosOfsubarraysxork {

    public static int count(int [] arr, int k)
    {
        int xr=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(xr, 1);
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            xr= xr^arr[i];
            int x= xr^k;

            if(map.containsKey(x))
            {
                count+= map.get(x);
            }
            if(map.containsKey(xr))
            {
                map.put(xr,map.get(xr)+1);
            }
            else {
                map.put(xr,1);
            }

        }
        return count;
    }
    public static void main(String[] args)
    {
        int arr[] = new int[]{4,2,2,6,4};
        System.out.println(count(arr,6));
    }

}
