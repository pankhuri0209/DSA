package striver;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class maxOccured {
    public static int maxOccured(int L[], int R[], int n){

        LinkedHashMap<Integer,Integer> map= new LinkedHashMap<>();
        // int len= L.length;
        // int j=0;
        for(int i=0;i<n;i++)
        {
            fillMap(map,L[i],R[i]);
            //j++;

        }
        int res= Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if( res> entry.getKey() && map.get(res)< entry.getValue() &&  map.get(res)!=entry.getValue() )
            {
                res= entry.getKey();
            }
        }
        return res;


    }
    public static void fillMap(LinkedHashMap<Integer,Integer> map, int start, int end){

        for(int i=start;i<=end;i++)
        {
            if(map.containsKey(i))
            {
                map.put(i,map.get(i)+1);
            }
            else
            {
                map.put(i,1);
            }
        }
    }
    public static void main(String[] args)
    {
        int[] L= {2,5,3,4,3,3,2,7,9,6};
        int[] R={4,5,6,7,8,3,10,10,10,10};
        int res =maxOccured(L,R,L.length);
        System.out.println(res);
    }
}
