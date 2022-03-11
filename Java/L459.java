public class L459 {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
        System.out.println(repeatedSubstringPattern("abc"));
        System.out.println(repeatedSubstringPattern("abcabcabcaba"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int[] next = new int[len];
        getNext(next, s);
        if (next[len - 1] != 0 && len % (len - next[len - 1]) == 0) {
            return true;
        }
        return false;
    }

    public static void getNext(int[] next, String s) {
        int left = 0, right, len = s.length();
        next[0] = 0;
        for (right = 1; right < len; right++) {
            while (left > 0 && s.charAt(left) != s.charAt(right)) {
                left = next[left - 1];
            }
            if (s.charAt(left) == s.charAt(right)) {
                left++;
            }
            next[right] = left;
        }
    }
}
