package bitsManipulation;

public class divide {
    public static long divide(long a, long b)
    {
        boolean sign = (a<0)^(b<0);
        long res = 0;
        a = Math.abs(a);
        b = Math.abs(b);

        while(a>=b){
            if(a == 0) break;
            long cnt = 0, temp = b;
            while(a>=temp){
                cnt++;
                temp = temp << 1;
            }
            a = a-(b<<(cnt-1));
            res += 1<<(cnt-1);
        }
        if(sign) return -res;
        return res;
    }
    public static void main(String[] args) {

        System.out.println(divide(10,3));
    }
}
