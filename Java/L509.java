public class L509 {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    public static int fib(int n) {
        if (n < 2) return n;

        int lastLastNum = 0, lastNum = 1, curNum = 0;
        for (int i = 2; i <= n; i++) {
            curNum = lastNum + lastLastNum;
            lastLastNum = lastNum;
            lastNum = curNum;
        }
        return curNum;
    }
}
