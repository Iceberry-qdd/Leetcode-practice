package C293;

import java.util.Arrays;

public class C6064 {
    public static void main(String[] args) {

    }

    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int len = special.length, result = 0;
        for (int i = 1; i < len; i++) {
            result = Math.max(special[i] - special[i - 1] - 1, result);
        }
        result = Math.max(result, top - special[len - 1]);
        result = Math.max(result, special[0] - bottom);
        return result;
    }
}
