import java.util.HashSet;
import java.util.Set;

public class L804 {
    public static final String[] table = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(uniqueMorseRepresentations(new String[]{"a"}));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        int len = words.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            String encodeStr = encode(words[i]);
            set.add(encodeStr);
        }
        return set.size();
    }

    public static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(table[ch - 'a']);
        }
        return sb.toString();
    }
}
