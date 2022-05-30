public class M1711 {
    public static void main(String[] args) {
        String[] words = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        System.out.println(findClosest(words, "a", "student"));
    }

    public static int findClosest(String[] words, String word1, String word2) {
        int len = words.length, result = Integer.MAX_VALUE;
        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (words[i].equals(word1)) left = i;
            if (words[i].equals(word2)) right = i;
            if (left != Integer.MIN_VALUE && right != Integer.MAX_VALUE) {
                result = Math.min(result, Math.abs(right - left));
            }
        }
        return result;
    }
}
