package striver;

public class rabinKarp {
    public static int repeatedStringMatch(String a, String b) {

        // int ind = a.indexOf(b);
        char firstChar= b.charAt(0); //find fist character in the string b
        int index= a.indexOf(firstChar); // index from b first found in string a

        int rem= b.length() - index;
        int res=1;
        while(b.length()>=index)
        {
            index+=a.length();
            res++;
        }
        return res;


    }

    public static void main(String[] args)
    {
        String input="-1";
        String a = "a", b = "aa";
        int res= repeatedStringMatch(a,b);
        System.out.println(res);
        // System.out.println(frequencyCount(L,N,P ));
    }
}
