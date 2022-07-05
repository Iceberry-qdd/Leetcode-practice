import java.util.Arrays;

public class L556 {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(2302431));
        System.out.println(nextGreaterElement(12));
        System.out.println(nextGreaterElement(21));

    }

    public static int nextGreaterElement(int n) {
        char[] nArr = String.valueOf(n).toCharArray();
        int len = nArr.length, i = len - 2, j = len - 1;

        if (len == 1 || (len == 2 && nArr[0] > nArr[1])) return -1;

        while (i > 0 && nArr[i] >= nArr[i + 1]) i--;
        while (j > 0 && nArr[j] <= nArr[i]) j--;

        char temp = nArr[j];
        nArr[j] = nArr[i];
        nArr[i] = temp;

        Arrays.sort(nArr, i + 1, len);

        try {
            int result = Integer.parseInt(String.valueOf(nArr));
            return result > n ? result : -1;
        } catch (Exception e) {
            return -1;
        }
    }
}
