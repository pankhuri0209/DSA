package bitsManipulation;

public class flip {
    public static int countBitsFlip(int a, int b){

        // Your code here
        int c= a^b;
        String str= Integer.toBinaryString(c);
        int count=0;
     //   System.out.println("c>"+c);
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='1')
            {count++;}
        }
        return count;
    }
    public static void main(String[] args) {

        System.out.println(countBitsFlip(10,20));
    }
}
