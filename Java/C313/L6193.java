package C313;

public class L6193 {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[][]{{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}}));
    }

    public static int maxSum(int[][] grid) {
        int m = grid.length, n = grid[0].length, result = 0;
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                result = Math.max(result, calcSum(grid, i, j));
            }
        }
        return result;
    }

    public static int calcSum(int[][] grid, int x, int y) {
        int result = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if ((i == x && j == y - 1) || (i == x && j == y + 1)) {
                    continue;
                }
                result += grid[i][j];
            }
        }
        return result;
    }
}
