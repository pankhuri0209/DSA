package striver;

public class countsay {
    public static String countAndSay(int n) {
        String val="1";


        for(int i=0;i<n-1;i++)
        {
            char c= val.charAt(0);
            StringBuilder s= new StringBuilder();
            int count=1;

            for(int j=1;j<val.length();j++)
            {
                if(c!=val.charAt(j))
                {
                    s.append(count);
                    s.append(c);
                    count=0;
                    c = val.charAt(j);
                }
                count++;
            }
            s.append(count);
            s.append(c);
            val= s.toString();
        }
        return val;
    }
    public static void main(String[] args)
    {
        String input="-1";
        String a = "ABC", b = "aa";
        String res= countAndSay(4);
        System.out.println(res);
        // System.out.println(frequencyCount(L,N,P ));
    }
}
