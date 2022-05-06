public class L123 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{1}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][5];
        dp[0] = new int[]{0, -prices[0], 0, -prices[0], 0};
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return dp[len - 1][4];
    }
}
