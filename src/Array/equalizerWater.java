package Array;

public class equalizerWater {

    public double equalizeWater(int[] buckets, int loss)
    {
        double low=0.0, high=0.0;
        for (int bucket: buckets)
        {
            high+=bucket;
        }
        high/=buckets.length;

        double tolerance= 1e-6;

        while (high-low> tolerance)
        {
            double mid= (high+low)/2;
            if (canEqualize(buckets, mid, loss))
            {
                low=mid;
            }
            else {
                high=mid;
            }
        }
        return low;

    }
    private boolean canEqualize(int[] buckets, double x, int loss)
    {
        double totalGive= 0.0;
        double totalTake= 0.0;

        double efficiency= (100-loss)/100.0;
        for (int bucket: buckets)
        {
            if (bucket > x)
            {
                totalGive+= (bucket-x) * efficiency;
            }
            else {
                totalTake+=(x-bucket);
            }
        }
        return  totalGive>=totalTake;
    }
}
