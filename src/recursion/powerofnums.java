package recursion;

public class powerofnums {
    public static void main(String[] args)
    {
        String S="-12";
        long ans= power(2,2);
        System.out.printf(String.valueOf(ans));
    }

    static long power(int n,int r)
    {
        if(r == 0) return 1;
        long result = power(n, r/2);
        result = (result * result) % 1000000007;
        if(r % 2 != 0) return (result * n) % 1000000007;
        return result;

    }
}
