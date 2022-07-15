public class L1252 {
    public static void main(String[] args) {
        System.out.println(oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
        System.out.println(oddCells(2, 2, new int[][]{{1, 1}, {0, 0}}));
    }

    public static int oddCells(int m, int n, int[][] indices) {
        int[][] grid = new int[m][n];
        int len = indices.length;
        for (int i = 0; i < len; i++) {
            int rowIndex = indices[i][0], colIndex = indices[i][1];
            for (int j = 0; j < n; j++) {
                grid[rowIndex][j]++;
            }

            for (int j = 0; j < m; j++) {
                grid[j][colIndex]++;
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % 2 != 0) result++;
            }
        }
        return result;
    }
}
