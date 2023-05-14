package bitsManipulation;

public class setbit {

    static int setBit(int N){
        // code here

        int ans=N;
        int pos=0;
        while(N!=0){
            if((N&1)==0){
                System.out.println("12");
                ans=(ans|(1<<pos));
                break;
            }
            pos++;
            N=N>>1;
        }
        return ans;


    }
    public static void main(String[] args) {

        System.out.println(setBit(1279));
    }
}
