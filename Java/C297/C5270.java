package C297;

import java.util.Arrays;

public class C5270 {
    public static void main(String[] args) {
        int[][] grid = {{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        System.out.println(minPathCost(grid, moveCost));
    }

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.min(dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j], dp[i][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[m - 1][i] < result) result = dp[m - 1][i];
        }
        return result;
    }
}
