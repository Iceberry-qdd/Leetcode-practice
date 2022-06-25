public class L5218 {
    public static void main(String[] args) {
        System.out.println(minimumNumbers(30, 4));
        System.out.println(minimumNumbers(10, 8));
        System.out.println(minimumNumbers(2, 8));
        System.out.println(minimumNumbers(37, 9));
        System.out.println(minimumNumbers(58, 9));
        System.out.println(minimumNumbers(37, 2));
        System.out.println(minimumNumbers(0, 7));
    }

    public static int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        if (k > num) return -1;
        if (k == 0) return num % 10 == 0 ? 1 : -1;
        if (k % 2 == 0 && num % 2 != 0) return -1;
        int lastValue = num % 10, result = 1;
        while (lastValue != result * k % 10) {
            if (result * k > num) return -1;
            result++;
        }
        return result;
    }
}
