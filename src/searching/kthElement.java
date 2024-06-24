package searching;

public class kthElement {
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        int[] arr3 = new int[n + m];
        int i = 0, j = 0, p = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                arr3[p++] = arr1[i++];
            } else {
                arr3[p++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1
        while (i < n) {
            arr3[p++] = arr1[i++];
        }

        // Copy remaining elements of arr2
        while (j < m) {
            arr3[p++] = arr2[j++];
        }

        // Return the kth element (k-1 because k is 1-based index)
        return arr3[k - 1];
    }
}
