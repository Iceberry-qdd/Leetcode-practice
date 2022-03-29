public class L693 {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
    }

    public static boolean hasAlternatingBits(int n) {
        int i = 0;
        while ((n >> i) > 0) {
            int num1 = n >> i;
            int num2 = n >> (i + 1);
            if (num1 == 0 || num2 == 0) break;
            if ((num1 & 1) == (num2 & 1)) return false;
            i++;
        }
        return true;
    }
}
