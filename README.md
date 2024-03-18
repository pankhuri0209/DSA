# DSA

 // Calculate the total size of the array needed
        int totalSize = linkedHashMap.values().stream().mapToInt(Integer::intValue).sum();

Todo:
1. Dutch National Flag Algo
https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/

2. Sort 2d array

   //sort the given intervals:
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

3. convert List<List<Integer>> ans= new ArrayList<>(); into arr[][]

List<List<Integer>> ans = new ArrayList<>();
// Assume the list is populated

int rows = ans.size();
int cols = ans.get(0).size(); // Assuming all inner lists have the same size

int[][] arr = new int[rows][cols];

for (int i = 0; i < rows; i++) {
    List<Integer> rowList = ans.get(i);
    for (int j = 0; j < cols; j++) {
        arr[i][j] = rowList.get(j);
    }
}        