public class J2091 {
    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(minCost(new int[][]{{7, 6, 2}}));
    }

    public static int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[len + 1][3];

        for (int i = 1; i <= len; i++) {
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2];
        }
        return min(dp[len][0], dp[len][1], dp[len][2]);
    }

    public static int min(int... nums) {
        int result = Integer.MAX_VALUE, len = nums.length;
        for (int i = 0; i < len; i++) {
            result = result > nums[i] ? nums[i] : result;
        }
        return result;
    }
}
