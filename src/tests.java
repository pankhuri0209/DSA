import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class tests {
    public static void main(String[] args)
    {
        String S="vrzr";
        String ans= longestPalin(S);
        System.out.printf(String.valueOf(ans));
    }
    static String longestPalin(String S){
        // code here

        String res="";
        boolean flag= false;
        ArrayList<String> list= new ArrayList<>();
        int limit= S.length();

        for(int i=0;i<limit;i++) {
            for (int j = i; j <=limit; j++) {
                res = S.substring(i, j);
                flag = isPalin(res);
                if (flag == true) {
                    list.add(res);
                    //return res;
                }
                flag=false;
            }
        }
        if(list.isEmpty())
        {
            return Character.toString(S.charAt(0));
            //return S.charAt(0).toString();
        }
        String longestString = list
                .stream()
                .max(Comparator.comparingInt(String::length))
                .get();
        return longestString;

    }
    static boolean isPalin(String s)
    {
        if(s.length()>=2) {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.reverse();
            if (s.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }
}
