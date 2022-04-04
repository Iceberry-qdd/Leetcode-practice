public class L1049 {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stones));
    }

    public static int lastStoneWeightII(int[] stones) {
        int len = stones.length, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }

        int[] dp = new int[sum / 2 + 1];

        for (int i = 0; i < len; i++) {
            for (int j = sum / 2; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[sum / 2] - dp[sum / 2];
    }
}
