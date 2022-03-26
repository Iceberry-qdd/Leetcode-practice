public class L70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i < n; i++) {
            dp[i + 1] = dp[i] + dp[i - 1];
        }
        return dp[n];
    }
}
