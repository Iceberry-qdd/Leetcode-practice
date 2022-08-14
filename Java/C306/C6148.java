package C306;

import java.util.Arrays;

public class C6148 {
    public static void main(String[] args) {
        int[][] result = largestLocal(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}});
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                maxLocal[i - 1][j - 1] = maxValue(grid, i - 1, j - 1);
            }
        }
        return maxLocal;
    }

    private static int maxValue(int[][] grid, int i, int j) {
        int result = 0;
        int j1 = j;
        for (int k = 0; k < 3; i++, k++) {
            j = j1;
            for (int l = 0; l < 3; j++, l++) {
                result = Math.max(grid[i][j], result);
            }
        }
        return result;
    }
}
