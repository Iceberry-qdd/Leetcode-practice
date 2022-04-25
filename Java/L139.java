import java.util.List;

public class L139 {
    public static void main(String[] args) {
        List<String> wordDict = List.of("leet", "code");
        System.out.println(wordBreak("leetcode", wordDict));

        wordDict = List.of("apple", "pen");
        System.out.println(wordBreak("applepenapple", wordDict));

        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak("catsandog", wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int lenS = s.length();
        boolean[] dp = new boolean[lenS + 1];
        dp[0] = true;

        for (int i = 1; i <= lenS; i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (wordDict.contains(substring) && dp[j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[lenS];
    }
}
