package stripe;

public class bestClosingTime {

    public int bestClosingTime(String customers) {
        int n  = customers.length();
        int penalty = 0;
        // penality if we close at 0
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty++;
            }
        }
        int bestJ=0, bestPenalty= penalty;
        for (int i=0;i<n;i++)
        {
            char c = customers.charAt(i);
            if (c=='Y')
            {
                penalty--;
            }
            else {
                penalty++;
            }
            int j=i+1;
            if (penalty<bestPenalty)
            {
                bestPenalty=penalty;
                bestJ=j;
            }
        }
        return  bestJ;
    }
}
