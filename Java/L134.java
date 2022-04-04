public class L134 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length, minRest = Integer.MAX_VALUE, costSum = 0, gasSum = 0, curRest = 0;
        for (int i = 0; i < len; i++) {
            costSum += cost[i];
            gasSum += gas[i];
            curRest += gas[i] - cost[i];
            minRest = Math.min(minRest, curRest);
        }

        if (costSum > gasSum) return -1;
        if (minRest >= 0) return 0;

        for (int i = len - 1; i >= 0; i--) {
            minRest += gas[i] - cost[i];
            if (minRest >= 0) return i;
        }
        return -1;
    }
}
