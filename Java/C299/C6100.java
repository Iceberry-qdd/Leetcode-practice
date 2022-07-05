package C299;

public class C6100 {
    private static final int MOD = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(countHousePlacements(i));
        }
    }

    public static int countHousePlacements(int n) {
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = dp[i - 1][0] % MOD;

        }
        long result = (dp[n - 1][0] + dp[n - 1][1]) * (dp[n - 1][0] + dp[n - 1][1]) % MOD;
        return (int) (result);
    }
}
