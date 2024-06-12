package striver;

public class minChars {
//    public static int solve(String A) {
//        int left= 0;
//        int right= A.length()-1;
//        // Convert the string A to a character array
//        char[] charArray = A.toCharArray();
//        System.out.println(charArray.toString());
//        int res=0;
//        while(left!=right && right>left)
//        {
//            if(charArray[left]!=charArray[right])
//            {
//                res++;
//            }
//            left++;
//            right--;
//
//        }
//        return res;
//    }
public static int solve(String A) {
    int len = A.length();
    String reverse = new StringBuffer(A).reverse().toString();
    A = A+"$"+reverse;
    return len - KMP(A);
}
    public static int KMP(String s){
        int m =s.length();
        int lps[] = new int[m];
        int i=1,len=0;lps[0]=0;
        while(i<m){
            if(s.charAt(i)==s.charAt(len)){
                len++;lps[i]=len;i++;
            }
            else{
                if(len!=0){
                    len = lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps[m-1];
    }
    public static void main(String[] args)
    {
        String input="-1";
        String a = "ABC", b = "aa";
        int res= solve(a);
        System.out.println(res);
        // System.out.println(frequencyCount(L,N,P ));
    }
}
