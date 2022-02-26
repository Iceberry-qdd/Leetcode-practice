import java.util.Arrays;

public class L66 {

    public static void main(String[] args) {
        int[] digit = {0};
        System.out.println(Arrays.toString(plusOne(digit)));

    }

    public static int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index > 0 && digits[index] == 9) {
            digits[index] = 0;
            index--;
        }
        digits[index] += 1;
        if (digits[0] == 10) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }
        return digits;
    }
}
