public class L28 {
    public static void main(String[] args) {
        String haystack = "aabaabaafa", needle = "aabaaf";
        System.out.println(strStr(haystack, needle));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("asc", ""));
        System.out.println(strStr("aaa", "aaaa"));
        System.out.println(strStr("mississippi", "sippia"));
    }

    public static int strStr(String haystack, String needle) {
        int lenH = haystack.length(), lenN = needle.length();
        if (lenN == 0) return 0;
        if (lenH < lenN) return -1;
        int[] next = new int[lenN];
        getNext(next, needle);

        for (int i = 0, j = 0; i < lenH; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == lenN) return i - lenN + 1;
        }
        return -1;
    }

    /**
     * 构造next数组
     *
     * @param next next数组
     * @param s    一个字符串
     */
    public static void getNext(int[] next, String s) {
        int left = 0, right, len = s.length();
        next[0] = 0;
        for (right = 1; right < len; right++) {
            while (left > 0 && s.charAt(left) != s.charAt(right)) {
                left = next[left - 1];
            }
            if (s.charAt(right) == s.charAt(left)) {
                left++;
            }
            next[right] = left;
        }
    }
}
