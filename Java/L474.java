public class L474 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < len; i++) {
            int zeroCount = 0, oneCount = 0;
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0') zeroCount++;
                else if (ch == '1') oneCount++;
            }

            for (int j = m; j >= zeroCount; j--) {
                for (int k = n; k >= oneCount; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroCount][k - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
