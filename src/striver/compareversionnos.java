package striver;

public class compareversionnos {

    public static int compareVersion(String version1, String version2) {
        // Split the version strings by '.'
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        // Find the maximum length of the two version arrays
        int maxLength = Math.max(v1.length, v2.length);

        // Iterate through each revision
        for (int i = 0; i < maxLength; i++) {
            // Convert the current revision to integer, treating missing parts as 0
            int rev1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int rev2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            // Compare the current revisions
            if (rev1 < rev2) {
                return -1;
            } else if (rev1 > rev2) {
                return 1;
            }
        }

        // All revisions are equal
        return 0;
    }
    public static void main(String[] args)
    {
        String input="-1";
        String a = "1.2", b = "1.10";
        int res= compareVersion(a,b);
        System.out.println(res);
        // System.out.println(frequencyCount(L,N,P ));
    }
}
