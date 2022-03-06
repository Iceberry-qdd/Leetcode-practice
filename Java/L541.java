public class L541 {
    public static void main(String[] args) {
//        String s = "abcdefghijklmno";
//        int k = 2;
//        System.out.println(reverseStr(s, k));
//        System.out.println(reverseStr("abcd",2));
//        System.out.println(reverseStr("abcdefg",2));
//        System.out.println(reverseStr("abcdefghijklmnop",3));
        System.out.println(reverseStr("abcdefg", 3));
    }

    public static String reverseStr(String s, int k) {
        int len = s.length();
        if (len < k) return reverseStr(s, 0, len - 1);
        int i = len / (2 * k);
        while (i > 0) {
            s = reverseStr(s, (i - 1) * 2 * k, (i - 1) * 2 * k + (k - 1));
            i--;
        }
        i = len / (2 * k);
        return (len % (2 * k) == 0) ? s : reverseStr(s, i * 2 * k, i * 2 * k + (k - 1));
    }

    // [begin, end]
    public static String reverseStr(String s, int begin, int end) {
        char[] chs = s.toCharArray();
        end = end > s.length() ? s.length() - 1 : end;
        while (begin < end) {
            chs[begin] ^= chs[end];
            chs[end] ^= chs[begin];
            chs[begin++] ^= chs[end--];
        }
        return String.valueOf(chs);
    }
}
