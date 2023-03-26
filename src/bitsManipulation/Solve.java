package bitsManipulation;

public class Solve {

    public static int solution(int n)
    {
    if(n==0){return 0;}

    int x= largestPowerof2inRange(n);
    int one= x* (1 <<(x-1));
    int two= n- (1<<x)+1;
    int rest= n-(1<<x);

    int ans= one+two+solution(rest);
    return ans;

    }

    public static int largestPowerof2inRange(int n)
    {
        int x=0;
        while((1<<x) <= n)
        {
            x++;
        }
        return x-1;
    }
    public static void main(String[] args) {

        System.out.println(solution(20));
    }
}
