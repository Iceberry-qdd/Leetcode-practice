package C295;

import java.util.Arrays;

public class C6078 {
    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("ilovecodingonleetcode","code"));
    }

    public static int rearrangeCharacters(String s, String target) {
        int sLen = s.length(), tLen = target.length(), result = Integer.MAX_VALUE;
        int[] alpha = new int[26], targetAlpha = new int[26];
//        Arrays.fill(alpha,-1);
//
        for (char ch : target.toCharArray()) {
            targetAlpha[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            alpha[ch - 'a']++;
        }

        for (int i = 0; i < targetAlpha.length; i++) {
            if (targetAlpha[i] == 0) continue;
            int curCount = alpha[i] / targetAlpha[i];
            result = Math.min(result, curCount);
        }
        return result;

    }
}
