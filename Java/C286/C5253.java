package C286;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class C5253 {
    public static void main(String[] args) {
        long[] queries = {1, 2, 3, 4, 5, 90};
        int intLength = 3;
        long[] result = kthPalindrome(queries, intLength);
        System.out.println(Arrays.toString(result));

        queries = new long[]{2, 4, 6};
        result = kthPalindrome(queries, 4);
        System.out.println(Arrays.toString(result));

        queries = new long[]{2, 201429812, 8, 520498110, 492711727, 339882032, 462074369, 9, 7, 6};
        result = kthPalindrome(queries, 1);
        System.out.println(Arrays.toString(result));
    }

    public static long[] kthPalindrome(long[] queries, int intLength) {
        double powIndex = Math.ceil(intLength / 2.0) - 1;
        long start = (long) Math.pow(10, powIndex);
        long end = (long) Math.pow(10, powIndex + 1);
        int len = queries.length;
        long[] result = new long[len];
        long maxCount = end - start;

        for (int i = 0; i < len; i++) {
            if (queries[i] > maxCount) {
                result[i] = -1;
                continue;
            }
            long halfNum = queries[i] - 1 + start;
            long num = convertToHuiwen(halfNum, intLength);
            result[i] = num;
        }
        return result;
    }

    public static long convertToHuiwen(long halfNum, int length) {
        String halfNumStr = String.valueOf(halfNum);
        int len = halfNumStr.length();
        StringBuilder sb = new StringBuilder(halfNumStr);
        int startIndex = length % 2 == 0 ? len - 1 : len - 2;
        for (int i = startIndex; i >= 0; i--) {
            sb.append(halfNumStr.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }
}
