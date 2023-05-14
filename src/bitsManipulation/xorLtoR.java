package bitsManipulation;

public class xorLtoR {
  static   int find(int num)

    {

        if(num%4==0) return num;

        if(num%4==1) return 1;

        if(num%4==2) return num+1;

        if(num%4==3) return 0;

        return 0;
    }

   static int findXOR(int l, int r) {

        int x=find(l-1);

        int y=find(r);

        return x^y;

    }
    public static void main(String[] args) {

        System.out.println(findXOR(1,5));
    }
}
