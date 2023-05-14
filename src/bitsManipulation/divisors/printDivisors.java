package bitsManipulation.divisors;

import java.util.ArrayList;

public class printDivisors {
    public static void print_divisors(int n) {
        ArrayList<Integer> arrlis=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                System.out.print(i+" ");
                if(i*i!=n)
                {arrlis.add(n/i);}
            }
        }
        for(int i=arrlis.size()-1;i>=0;i--)
            System.out.print(arrlis.get(i)+" ");
    }
    public static void main(String[] args) {

        int[] arr = new int[]{4, 2, 4, 5, 2, 3, 3, 1};
        print_divisors(27);
    }
}
