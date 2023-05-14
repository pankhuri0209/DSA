package bitsManipulation;

public class twoOddnums {
    public static int[] twoOddNum(int arr[], int N)
    {
        // code here
        int ans[]=new int[2];

        int sum=0;

        for(int i=0;i<N;i++){

            sum^=arr[i];

        }

        int p=0,q=0;

        int rsetbit=sum&(~(sum-1));//GIVES RIGHTMOST SET BIT

        for(int i=0;i<N;i++){

            if((arr[i]&rsetbit)!=0){

                p=p^arr[i];

            }

            else{

                q=q^arr[i];

            }

        }

        ans[0]=Math.max(p,q);

        ans[1]=Math.min(p,q);

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{4, 2, 4, 5, 2, 3, 3, 1};
        System.out.println(twoOddNum(arr,8));
    }
}
