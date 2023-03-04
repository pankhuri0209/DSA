public class search {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,7,8,9,10,1,2,3};
        // long ans= maxProduct(arr,arr.length);
        int ans = search_1(arr, 0, arr.length - 1, 1);
        System.out.println(ans);
    }
    public  static int search_1(int nums[], int l, int h, int key)
    {
    while(l<=h)

    {
        int mid = l + (h - l) / 2;

        if (nums[mid] > key && nums[l] > key) {

            l++;

        } else if (nums[mid] > key && nums[h] > key) {

            h--;

        } else {
            if (nums[l] == key) {
                return l;
            }
            if (nums[h] == key) {
                return h;
            }
            l++;
            h--;
        }
    }
     return-1;
}
    public  static int search(int a[], int l, int r, int key)
    {
        l=0;
        r=a.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(a[mid]==key) return mid;
            if(a[l]<=a[mid]){
                if(key>=a[l]&&key<=a[mid]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{
                if(key<a[r]&&key>a[mid]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }

}
