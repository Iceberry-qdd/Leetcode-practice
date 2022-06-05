import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class L473 {
    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(makesquare(new int[]{3, 3, 3, 3, 4}));
    }

    public static boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum(), len = matchsticks.length;
        if (sum % 4 != 0 || len < 4) return false;

        int edgeLength = sum / 4;
        Arrays.sort(matchsticks);

        if (matchsticks[len - 1] > edgeLength) return false;

        int[] bucket = {0, 0, 0, 0};
        return backTracing(0, edgeLength, bucket, matchsticks);
    }

    public static boolean backTracing(int i, int edgeLength, int[] bucket, int[] matchsticks) {
        int len = matchsticks.length;
        if (i == len) return true;

        for (int j = 0; j < 4; j++) {
            if (matchsticks[i] + bucket[j] <= edgeLength) {
                if (j == 0 || bucket[j] != bucket[j - 1]) {
                    bucket[j] += matchsticks[i];
                    if (backTracing(i + 1, edgeLength, bucket, matchsticks)) return true;
                    bucket[j] -= matchsticks[i];
                }
            }
        }
        return false;
    }
}
