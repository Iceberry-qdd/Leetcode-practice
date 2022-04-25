public class L738 {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits(100));
        System.out.println(monotoneIncreasingDigits(101));
    }

    public static int monotoneIncreasingDigits(int n) {
        char[] str = String.valueOf(n).toCharArray();
        int len = str.length, index = len;
        for (int i = len - 1; i > 0; i--) {
            if (str[i - 1] > str[i]) {
                index = i;
                str[i - 1]--;
            }
        }
        for (int i = index; i < len; i++) {
            str[i] = '9';
        }
        return Integer.parseInt(String.valueOf(str));
    }
}
