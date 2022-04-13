import java.util.Arrays;

public class L806 {
    public static void main(String[] args) {
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        int[] result = numberOfLines(widths, s);
        System.out.println(Arrays.toString(result));

        widths = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        s = "bbbcccdddaaa";
        result = numberOfLines(widths, s);
        System.out.println(Arrays.toString(result));
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int curLineWidth = 100, result = 1;
        for (char ch : s.toCharArray()) {
            if (curLineWidth - widths[ch - 'a'] < 0) {
                result++;
                curLineWidth = 100;
            }
            curLineWidth -= widths[ch - 'a'];
        }
        return new int[]{result, 100 - curLineWidth};
    }
}
