package striver;

public class rabinKarp {
    public static int repeatedStringMatch(String a, String b) {

        int count = 1;
        StringBuilder repeatedA = new StringBuilder(a);

        // Calculate the minimum number of repetitions required
        while (repeatedA.length() < b.length()) {
            repeatedA.append(a);
            count++;
        }

        // Check if b is a substring of the current repeated string
        if (repeatedA.indexOf(b) != -1) {
            return count;
        }

        // Append one more repetition and check again
        repeatedA.append(a);
        count++;

        if (repeatedA.indexOf(b) != -1) {
            return count;
        }

        // If b is still not a substring, return -1
        return -1;



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
