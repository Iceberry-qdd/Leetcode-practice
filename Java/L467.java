public class L467 {
    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("a"));
        System.out.println(findSubstringInWraproundString("cac"));
        System.out.println(findSubstringInWraproundString("zab"));
    }

    public static int findSubstringInWraproundString(String p) {
        char[] arr = p.toCharArray();
        int len = arr.length, subStrLen = 1, result = 0;
        int[] dp = new int[26];
        dp[arr[0] - 'a'] = 1;

        for (int i = 1; i < len; i++) {
            if (arr[i] - arr[i - 1] == 1 || (arr[i - 1] == 'z' && arr[i] == 'a')) {
                subStrLen++;
            } else subStrLen = 1;
            dp[arr[i] - 'a'] = Math.max(dp[arr[i] - 'a'], subStrLen);
        }

        for (int n : dp) {
            result += n;
        }
        return result;
    }
}
