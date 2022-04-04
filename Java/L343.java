public class L343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];      // dp[0]和dp[1]无意义，数组最后下标为n
        dp[2] = 1;                      // 从dp[2]开始计算

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                // 当前循环中所能得出的dp[i]的最大乘积，为 max{ 分成两个数, 分成多个数 }
                // 分成两个数的情况即为 i = (i - 1) * 1 = (i - 2) * 2 = ... = 1 * (i - 1)
                // 分成多个数的情况即为前几个数的最大乘积 dp[i-j] 与 i - (i-j) 的乘积
                int curMaxTimes = Math.max((i - j) * j, dp[i - j] * j);

                //一个dp[i]要经过好几轮循环才能确定，总要取每轮循环中的最大值，curMaxTimes不一定是最大值
                dp[i] = Math.max(dp[i], curMaxTimes);
            }
        }
        return dp[n];
    }
}
