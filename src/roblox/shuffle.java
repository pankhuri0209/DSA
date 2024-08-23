package roblox;

public class shuffle {
    public static int[] shuffle(int[] nums, int n) {
        int pointer1=0, pointer2=0;
        int[] res= new int[nums.length];
        if(n>0)
        {
            pointer1=0;
            pointer2 = n;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(i%2!=0)
            {
                res[i]= nums[pointer2];
                pointer2++;
            }
            else
            {
                res[i]= nums[pointer1];
                pointer1++;
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        int[] num = new int[]{2,5,1,3,4,7};

        int[] res= shuffle(num, 3);
        System.out.println(res.toString());
    }
}
