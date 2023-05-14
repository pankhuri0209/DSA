package bitsManipulation;

import java.util.ArrayList;

public class prime {
    public static void main(String[] args) {

        int[] arr = new int[]{4, 2, 4, 5, 2, 3, 3, 1};
        System.out.println(AllPrimeFactors(100));
    }
    public static int[] AllPrimeFactors(int n)

    {

        // code here

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 2; i<=n; i++){

            if((n%i)==0 && isPrime(i)==true){

                ans.add(i);

            }

        }

        int[] arr = ans.stream().mapToInt(i->i).toArray();



        return arr;

    }

    public static boolean isPrime(int n){

        for(int i = 2; i*i<=n; i++){

            if(n%i==0)

                return false;

        }

        return true;

    }
}
