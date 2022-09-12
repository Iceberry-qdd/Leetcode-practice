import java.util.Arrays;

public class L667 {
    public static void main(String[] args) {
        int[] result = constructArray(50, 20);
        System.out.println(Arrays.toString(result));
    }

    public static int[] constructArray(int n, int k) {
        int[] result = new int[n];
        for (int i = 0, num = 1; i <= k; i += 2) {
            result[i] = num++;
        }

        for (int i = 1, num = 1 + k; i <= k; i += 2) {
            result[i] = num--;
        }
        for (int i = k + 1; i < n; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
