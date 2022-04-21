import java.util.Arrays;

public class L5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length(), maxLength = 0, left = 0, right = 0;
        boolean[][] dp = new boolean[len + 1][len + 1];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)) continue;
                if (j - i <= 1) dp[i][j] = true;
                else if (dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
