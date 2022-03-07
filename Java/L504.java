import java.util.Arrays;

public class L504 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
        System.out.println(convertToBase7(0));
        System.out.println(convertToBase7(999));
    }

    public static String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }

        while (num >= 7) {
            sb.append(num % 7);
            num = num / 7;
        }
        sb.append(num);
        if (isNegative) sb.append("-");
        return reverseString(sb.toString());
    }

    public static String reverseString(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int left = 0, right = len - 1;
        while (left < right) {
            chs[left] ^= chs[right];
            chs[right] ^= chs[left];
            chs[left++] ^= chs[right--];
        }
        return String.valueOf(chs);
    }
}
