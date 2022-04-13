public class L375 {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println(countNumbersWithUniqueDigits(i));
        }
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (11 - i);
        }
        return dp[n];
    }
}
