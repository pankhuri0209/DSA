public class atoi {
    public static void main(String[] args) throws Exception {
        String S="A123";
        int ans= atoi(S);
        System.out.printf(String.valueOf(ans));
    }
    static int atoi(String str) throws Exception {
        // Your code here
        int res=0;
        try
        {
            for(int i=0;i<str.length();i++)
            {
                res= res*10  +str.charAt(i) -'0';
            }
        }
        catch(NumberFormatException  e)
        {
            return -1;
        }
        return res;
    }
}
