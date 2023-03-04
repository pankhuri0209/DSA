import java.util.HashMap;
import java.util.Map;

public class roman {
    public static void main(String[] args)
    {
        String S="DCCC";
        int ans= romanToDecimal(S);
        System.out.printf(String.valueOf(ans));
    }

    public static int romanToDecimal(String s) {
        // code here
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        s= s.replace("IV","IIII");
        s= s.replace("IX","VIIII");
        s= s.replace("XL","XXXX");
        s= s.replace("XC","LXXXX");
        s= s.replace("CM","DCCCC");
        s= s.replace("CD","CCCC");

        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == 'I' || s.charAt(i)== 'V' || s.charAt(i) == 'X' || s.charAt(i) == 'L' || s.charAt(i) == 'C' || s.charAt(i) == 'D' || s.charAt(i) == 'M')
            {
                sum+=map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
