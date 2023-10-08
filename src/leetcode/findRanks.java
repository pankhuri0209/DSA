package leetcode;

import java.util.*;

public class findRanks {

    public static String[] findRelativeRanks(int[] score) {

//        String [] res= new String[score.length];
//        Arrays.sort(score);
//        for(int i=0;i<score.length;i++)
//        {
//            switch(score[i])
//            {
//                case 1:
//                    res[i]="Gold Medal";
//                case 2:
//                    res[i]="Silver Medal";
//                case 3:
//                    res[i]="Bronze Medal";
//                default:
//                    res[i]=Integer.toString(score[i]);
//            }
//        }
//        return res;
        int count=0;
        int countr=4;

        ArrayList<Integer> list= new ArrayList<>();
        String [] re= new String[score.length];
        HashMap<Integer, String> map= new HashMap<>();

        for(int i=0;i<score.length;i++)
        {
            list.add(score[i]);
        }
        Collections.sort(list);

        for(int i=list.size()-1;i>=0;i--)
        {
            count++;

            if(count <=3)
            {
                if(count==1)
                {
                    map.put(list.get(i),"Gold Medal" );
                }
                else if(count==2)
                {
                    map.put(list.get(i),"Silver Medal" );
                }
                else {
                    map.put(list.get(i), "Bronze Medal");
                }
            }
            else
            {
                map.put(list.get(i), String.valueOf(countr));
                countr++;
            }
        }
        for(int i=0;i<score.length;i++)
        {
            for(Map.Entry<Integer,String> e: map.entrySet())
            {
                if(score[i] ==e.getKey())
                {
                    re[i]= e.getValue();
                }
            }
        }
        return re;

    }


}
