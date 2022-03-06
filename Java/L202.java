import java.util.HashSet;
import java.util.Set;

public class L202 {
    public static void main(String[] args) {
        int n = 19;
        System.out.printf("%d is a happy number? %b\n", n, isHappy(n));
        System.out.printf("%d is a happy number? %b\n", 2, isHappy(2));
        System.out.printf("%d is a happy number? %b\n", 16352, isHappy(16352));
    }

    public static boolean isHappy(int n) {
        Set<Integer> sums = new HashSet<>();
        int sum = 0, num;
        while (sum != 1) {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            while (n != 0) {
                num = n % 10;
                n = n / 10;
                sum += num * num;
            }
            if (sums.contains(sum)) return false;
            else sums.add(sum);
        }
        return true;
    }
}
