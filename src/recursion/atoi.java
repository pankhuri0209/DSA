package recursion;

public class atoi {
    public static void main(String[] args)
    {
        String S="-12";
        int ans= atoi(S);
        System.out.printf(String.valueOf(ans));
    }
    static int atoi(String str) {
        // Your code here
        boolean f= false;

        if(str.charAt(0) == '-')
        {
            f= true;
        }
        if(f==true)
        {
            if(str.substring(1).matches("^\\d*$"))
            {
                return -1;
            }
            return -atoi(str.substring(1),str.length()-1);
        }
        return atoi(str,str.length());

    }

    static int atoi(String str, int n)
    {

        if(str=="" || !str.matches("^\\d*$")  || str.contains("-"))
        {
            return -1;
        }

        if(n==1)
        {
            return str.charAt(0) - '0';
        }

        return (10*atoi(str,n-1)) +(str.charAt(n-1)-'0');

    }
}
