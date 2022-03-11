import java.util.ArrayDeque;
import java.util.Deque;

public class L1047 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        int len = s.length();
        if (len == 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (sb.length() != 0 && s.charAt(i) == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
