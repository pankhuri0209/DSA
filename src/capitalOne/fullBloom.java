package capitalOne;

import java.util.ArrayList;
import java.util.List;

public class fullBloom {

    public List<Integer> fullBloomflowers(List<List<Integer>> flowers, List<Integer> people)
    {
        int m = flowers.size();
        int n = people.size();

        List<Integer> res= new ArrayList<>(n);

        for (int i=0;i<n;i++)
        {
            res.add(0);
        }
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                int start= flowers.get(j).get(0);
                int end= flowers.get(j).get(1);

                if(people.get(i)>= start && people.get(i)<=end)
                {
                    res.set(i, res.get(i)+1);
                }
            }
        }
        return res;

    }
}
