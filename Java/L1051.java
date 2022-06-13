public class L1051 {
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.println(heightChecker(new int[]{5, 1, 2, 3, 4}));
        System.out.println(heightChecker(new int[]{1, 2, 3, 4, 5}));
    }

    public static int heightChecker(int[] heights) {
        int len = heights.length, result = 0;
        int[] count = new int[101];
        for (int i = 0; i < len; i++) {
            count[heights[i]]++;
        }

        for (int i = 0, j = 0; i < len; i++) {
            while (count[j] == 0) j++;
            if (heights[i] != j) result++;
            count[j]--;
        }
        return result;
    }
}
