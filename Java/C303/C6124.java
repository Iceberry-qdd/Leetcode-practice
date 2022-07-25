package C303;

import java.util.HashMap;
import java.util.Map;

public class C6124 {
    public static void main(String[] args) {

    }

    public char repeatedCharacter(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else return s.charAt(i);
        }
        return ' ';
    }
}
