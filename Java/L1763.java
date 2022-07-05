import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L1763 {
    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
        System.out.println(longestNiceSubstring("Bb"));
        System.out.println(longestNiceSubstring("c"));
        System.out.println(longestNiceSubstring("dDzeE"));
        System.out.println(longestNiceSubstring("XqLJWaEEcAjslIXxKZgufikxFwVVYUlvYrIeGRyS"));
    }

    public static String longestNiceSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        String result = "";
        int length = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (check(arr, i, j) && j - i + 1 > length) {
                    result = s.substring(i, j + 1);
                    length = j - i + 1;
                }
            }
        }
        return result;
    }

    public static boolean check(char[] arr, int left, int right) {
        Set<Character> set = new HashSet<>();
        for (int i = left; i <= right; i++) {
            set.add(arr[i]);
        }

        for (Character ch : set) {
            if (Character.isLowerCase(ch) && !set.contains(Character.toUpperCase(ch))) {
                return false;
            } else if (Character.isUpperCase(ch) && !set.contains(Character.toLowerCase(ch))) {
                return false;
            }
        }
        return true;
    }
}
