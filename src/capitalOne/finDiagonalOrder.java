package capitalOne;

import java.util.*;

public class finDiagonalOrder {

    public int[] findDiagnolOrder(int[][] mat)
    {
        int m= mat.length;
        int n= mat[0].length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> result= new ArrayList<>();

        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                int key = i+j;
                if (!map.containsKey(key))
                {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
            }


        }
        boolean flip= true;
        for (int key: map.keySet())
        {
            List<Integer> list = map.get(key);
            if (flip)
            {
                Collections.reverse(list);
            }
            result.addAll(list);
            flip= !flip;
        }
        int [] resArray= new int[result.size()];
        for (int i=0;i< result.size();i++)
        {
            resArray[i] = result.get(i);
        }
        return  resArray;

    }
}
