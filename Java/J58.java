import java.util.Arrays;

public class J58 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
        System.out.println(reverseLeftWords("lrloseumgh", 6));
        System.out.println(reverseLeftWords("l", 6));
    }

    public static String reverseLeftWords(String s, int n) {
        int len = s.length();
        if (len == 1) return s;
        s = reverseString(s, 0, n - 1);
        s = reverseString(s, n, len - 1);
        s = reverseString(s, 0, len - 1);
        return s;
    }

    public static String reverseString(String s, int start, int end) {
        char[] chs = s.toCharArray();
        while (start < end) {
            chs[start] ^= chs[end];
            chs[end] ^= chs[start];
            chs[start] ^= chs[end];
            start++;
            end--;
        }
        return String.valueOf(chs);
    }
}
