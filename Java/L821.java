import java.util.Arrays;

public class L821 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int[] result = shortestToChar(s, 'e');
        System.out.println(Arrays.toString(result));

        s = "aaab";
        result = shortestToChar(s, 'b');
        System.out.println(Arrays.toString(result));

        s = "aaba";
        result = shortestToChar(s, 'b');
        System.out.println(Arrays.toString(result));
    }

    public static int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] result = new int[len];
        int lastTargetIndex = Integer.MAX_VALUE;
        //计算距离result[i]左边最近的c的距离
        for (int i = 0; i < len; i++) {
            char curChar = s.charAt(i);
            if (curChar == c) {
                result[i] = 0;
                lastTargetIndex = i;
            } else if (lastTargetIndex != Integer.MAX_VALUE) {
                result[i] = i - lastTargetIndex;
            } else result[i] = Integer.MAX_VALUE;
        }

        //计算距离result[i]右边最近的c的距离，并与上述操作的值作比较，取较小值作为最终值
        lastTargetIndex = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            char curChar = s.charAt(i);
            if (curChar == c) {
                result[i] = 0;
                lastTargetIndex = i;
            } else if (lastTargetIndex != Integer.MAX_VALUE) {
                result[i] = Math.min(result[i], lastTargetIndex - i);
            } else result[i] = Math.min(result[i], lastTargetIndex);
        }
        return result;
    }
}
