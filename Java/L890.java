import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L890 {
    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        List<String> result = findAndReplacePattern(words, "abb");
        System.out.println(result);
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        char[] pArray = pattern.toCharArray();
        int wLen = words.length, pLen = pArray.length;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < wLen; i++) {
            Map<Character, Character> map = new HashMap<>();
            boolean flag = true;
            for (int j = 0; j < pLen; j++) {
                char ch = words[i].charAt(j);
                if (!map.containsKey(pArray[j]) && !map.containsValue(ch)) {
                    map.put(pArray[j], ch);
                } else if (map.containsKey(pArray[j]) && map.get(pArray[j]) == ch) {
                    map.put(pArray[j], ch);
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) result.add(words[i]);
        }
        return result;
    }
}
