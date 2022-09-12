package C309;

import java.util.HashMap;
import java.util.Map;

public class C6167 {
    public static void main(String[] args) {
        System.out.println(checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public static boolean checkDistances(String s, int[] distance) {
        int len = s.length();
        int[] arr = new int[26];

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(s.charAt(i))) {
                Integer lastIndex = map.get(ch);
                arr[ch - 'a'] = i - lastIndex - 1;
            }
            map.put(ch, i);
        }

        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            if (arr[idx] != distance[idx]) {
                return false;
            }
        }
        return true;
    }
}
