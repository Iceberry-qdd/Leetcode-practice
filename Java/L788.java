import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L788 {
    public static void main(String[] args) {

    }

    public static int rotatedDigits(int n) {
        Set<Character> goodSet1, goodSet2;
        goodSet1 = new HashSet<>(List.of('2', '5', '6', '9'));
        goodSet2 = new HashSet<>(List.of('0', '1', '8'));

        int result = 0;
        for (int i = 2; i <= n; i++) {
            String s = String.valueOf(i);
            boolean flag = true, camp = false;
            for (char ch : s.toCharArray()) {
                if (!goodSet1.contains(ch) && !goodSet2.contains(ch)) {
                    flag = false;
                    break;
                } else if (goodSet1.contains(ch)) {
                    camp = true;
                }
            }
            if (flag && camp) {
                result++;
            }
        }
        return result;
    }
}
