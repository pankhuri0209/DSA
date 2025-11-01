package Neetcode.greedy;

public class canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;   // total surplus across all stations
        int tank = 0;    // current surplus since last candidate start
        int start = 0;
        for (int i=0;i<n;i++){
            int gain = gas[i] - cost[i];
            total += gain;
            tank += gain;

            // If we can't reach the next station from current start,
            // move start to i+1 and reset the running tank.
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
