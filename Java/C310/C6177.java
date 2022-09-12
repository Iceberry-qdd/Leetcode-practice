package C310;

import java.util.HashSet;
import java.util.Set;

public class C6177 {
    public static void main(String[] args) {

    }

    public static int partitionString(String s) {
        int len = s.length(), result = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.contains(s.charAt(i))) {
                result++;
                set.clear();
            }
            set.add(s.charAt(i));
        }
        return result;
    }
}
