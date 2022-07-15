import java.util.ArrayList;
import java.util.List;

public class L1380 {
    public static void main(String[] args) {
        List<Integer> result = luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}});
        System.out.println(result);

        result = luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}});
        System.out.println(result);

        result = luckyNumbers(new int[][]{{7, 8}, {1, 2}});
        System.out.println(result);
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            list.add(min);
        }

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            int index = list.indexOf(max);
            if (index != -1) {
                result.add(list.get(index));
            }
        }
        return result;
    }
}
