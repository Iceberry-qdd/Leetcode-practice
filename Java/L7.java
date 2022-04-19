public class L7 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(0));
        System.out.println(reverse(Integer.MAX_VALUE - 1));
        System.out.println(reverse(120));
    }

    public static int reverse(int x) {
        int result = 0, lastResult = 0;
        while (x != 0) {
            result = x % 10 + result * 10;
            if (result / 10 != lastResult) return 0;
            lastResult = result;
            x = x / 10;
        }
        return result;
    }
}
