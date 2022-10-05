import java.util.HashMap;
import java.util.Map;

public class L1624 {
    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("abcabbsba"));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int len = s.length(), length = -1;
        for (int i = 0; i < len; i++) {
            int n = s.lastIndexOf(s.charAt(i));
            length = Math.max(length, n - i - 1);
        }
        return length;
    }
}
