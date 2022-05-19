package C293;

import java.util.*;

public class C5234 {
    public static void main(String[] args) {
        String[] words = {"a", "b", "a"};
        List<String> result = removeAnagrams(words);
        System.out.println(result);
    }

    public static List<String> removeAnagrams(String[] words) {
        int len = words.length;
        String lastRealString = "";
        List<String> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            String realString = getRealString(words[i]);
            if (!realString.equals(lastRealString)) {
                result.add(words[i]);
            }
            lastRealString = realString;
        }
        return result;
    }

    public static String getRealString(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        map.forEach((key, value) -> {
            sb.append(key).append(value);
        });
        return sb.toString();
    }
}
