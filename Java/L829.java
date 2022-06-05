public class L829 {
    public static void main(String[] args) {
        int[] test = {5, 9, 15};
        for (int i : test) {
            System.out.println(consecutiveNumbersSum(i));
        }
    }

    public static int consecutiveNumbersSum(int n) {
        int result = 0;
        for (int i = 1; i * (i + 1) <= 2 * n; i++) {
            if ((2 * n) % i == 0 && (((2 * n) / i - i) & 1) != 0) {
                result++;
            }
        }
        return result;
    }
}
