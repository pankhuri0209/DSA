import java.util.Arrays;

public class reverseString {

    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 5, 5, 5, 10, 5, 5};

        String ans = reverseWords("i.like.this.program.very.much");
        System.out.println(ans);
    }
    public static String reverseWords(String S)
    {
        String[] arr = S.split("[.]");
        StringBuilder res= new StringBuilder("");
        for(int i=arr.length-1;i>=0;i--)
        {
          res.append(arr[i]);
          if(i!=0)
            {
              res.append(".");
            }
        }
        return  res.toString();
    }
}
