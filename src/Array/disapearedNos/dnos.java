package Array.disapearedNos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class dnos {
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res= new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
      //  int j=0;
        for(int i=1; i<=nums.length;i++)
        {
            map.put(i,0);
            if(Arrays.stream(nums).boxed().collect(Collectors.toList()).contains(i))
            {
                map.put(i,map.get(i)+1);
            }
            //map.put()
           // j++;
        }
        for(int i=1;i<=nums.length;i++)
        {
            if(map.get(i)==0)
            {
                res.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{4,3,2,7,8,3,2,1};
        // String[] B= new String[]{"story","fleet","leetcode"};

        findDisappearedNumbers(A);

        //  System.out.println(res);
    }
}
