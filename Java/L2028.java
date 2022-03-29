import java.util.Arrays;

public class L2028 {
    public static void main(String[] args) {
        int[] rolls = {3, 2, 4, 3};
        int mean = 4, n = 2;
        int[] result = missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(result));

        rolls = new int[]{1, 5, 6};
        result = missingRolls(rolls, 3, 4);
        System.out.println(Arrays.toString(result));

        rolls = new int[]{1, 2, 3, 4};
        result = missingRolls(rolls, 6, 4);
        System.out.println(Arrays.toString(result));

        rolls = new int[]{1};
        result = missingRolls(rolls, 3, 1);
        System.out.println(Arrays.toString(result));

        rolls = new int[]{6,3,4,3,5,3};
        result = missingRolls(rolls, 3, 1);
        System.out.println(Arrays.toString(result));

        rolls = new int[]{4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3};
        result = missingRolls(rolls, 2, 53);
        System.out.println(Arrays.toString(result));

    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int nSum = (m + n) * mean - Arrays.stream(rolls).sum();
        if (nSum < 0 || nSum < n) return new int[]{};
        int[] result = new int[n];
        if (nSum / n > 6) return new int[]{};
        for (int i = 0; i < n; i++) {
            if (nSum / n >= 1 && nSum / n <= 6) {
                result[i] = nSum / n;
            }
        }

        nSum -= (nSum / n) * n;
        if (nSum > 0 && result[0] == 6) return new int[]{};
        if (nSum == 0) return result;
        if (nSum > 0 && result[0] < 6) {
            int i = 0;
            while (nSum > 0) {
                if (i == n) i = 0;
                if (result[i] == 6) return new int[]{};
                result[i++]++;
                nSum--;
            }
        }
        return result;
    }
}
