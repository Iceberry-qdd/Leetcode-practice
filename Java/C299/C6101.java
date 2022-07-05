package C299;

public class C6101 {
    public static void main(String[] args) {
        System.out.println(checkXMatrix(new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}}));
    }

    public static boolean checkXMatrix(int[][] grid) {
        return condition1(grid) && condition2(grid);
    }

    public static boolean condition1(int[][] grid) {
        int len = grid.length;
        for (int i = 0; i < len; i++) {
            if (grid[i][i] == 0 || grid[i][len - 1 - i] == 0) return false;
        }
        return true;
    }

    public static boolean condition2(int[][] grid) {
        int len = grid.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j || i == len - 1 - j) continue;
                if (grid[i][j] != 0) return false;
            }
        }
        return true;
    }
}
