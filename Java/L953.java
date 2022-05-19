import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L953 {
    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));

        words = new String[]{"word", "world", "row"};
        order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(words, order));

        words = new String[]{"apple", "app"};
        order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));

        words = new String[]{"kuvp", "q"};
        order = "ngxlkthsjuoqcpavbfdermiywz";
        System.out.println(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int wLen = words.length, oLen = order.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < oLen; i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < wLen - 1; i++) {
            char[] word1 = words[i].toCharArray(), word2 = words[i + 1].toCharArray();
            if (!check(word1, word2, map)) return false;
        }
        return true;
    }

    public static boolean check(char[] word1, char[] word2, Map<Character, Integer> map) {
        int w1Len = word1.length, w2Len = word2.length;
        for (int j = 0; j < w1Len && j < w2Len; j++) {
            if (map.get(word1[j]) - map.get(word2[j]) > 0) {
                return false;
            } else if (map.get(word1[j]) - map.get(word2[j]) < 0) {
                return true;
            }
        }
        return w1Len <= w2Len;
    }
}
