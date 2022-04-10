public class L518 {
    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
        System.out.println(change(3, new int[]{2}));
        System.out.println(change(10, new int[]{10}));
    }

    public static int change(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];

        dp[0] = 1;
        for (int i = 0; i < len; i++) {// 遍历硬币
            for (int j = coins[i]; j <= amount; j++) {// 遍历背包
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
