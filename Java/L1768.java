public class L1768 {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int minLen = Math.min(len1, len2), maxLen = Math.max(len1, len2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            if (i < minLen) {
                sb.append(word1.charAt(i)).append(word2.charAt(i));
            } else {
                if (len1 > len2) {
                    sb.append(word1, i, len1);
                } else {
                    sb.append(word2, i, len2);
                }
                break;
            }
        }
        return sb.toString();
    }
}
