package bitsManipulation.powerofnos;

public class power {
    static long power(int n,int r)
    {
        if(r == 0) return 1;
        long result = power(n, r/2);
        result = (result * result) % 1000000007;
        if(r % 2 != 0) return (result * n) % 1000000007;
        return result;

    }
    public static void main(String[] args) {

        int[] arr = new int[]{4, 2, 4, 5, 2, 3, 3, 1};
        power(12,21);
    }
}
