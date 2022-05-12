public class L944 {
    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        System.out.println(minDeletionSize(new String[]{"a", "b"}));
        System.out.println(minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }

    public static int minDeletionSize(String[] strs) {
        int result = 0, rowLen = strs.length, colLen = strs[0].length();
        for (int i = 0; i < colLen; i++) {
            char lastChar = strs[0].charAt(i);
            for (int j = 1; j < rowLen; j++) {
                char curChar = strs[j].charAt(i);
                if (curChar < lastChar) {
                    result++;
                    break;
                }
                lastChar = curChar;
            }
        }
        return result;
    }
}
