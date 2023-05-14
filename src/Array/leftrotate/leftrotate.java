package Array.leftrotate;

public class leftrotate {
    static void leftRotate(long arr[], int k, int n) {

        long a[] = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = arr[(i + k) % n];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }

    }
    public static void main(String[] args) {

        long[] arr = new long[]{1,2,2,3,3,4,4,4};
        leftRotate(arr,2,arr.length);
    }
}
