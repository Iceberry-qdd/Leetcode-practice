public class L63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int result = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length, colLen = obstacleGrid[0].length;
        int[][] dp = new int[rowLen][colLen];
        for (int i = 0; i < rowLen && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < colLen && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[rowLen - 1][colLen - 1];
    }
}
