import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1260 {
    public static void main(String[] args) {
        List<List<Integer>> result = shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
        System.out.println(result);
        result = shiftGrid(new int[][]{{100}}, 0);
        System.out.println(result);
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] arr = new int[m][n];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = grid[i][j];
            }
        }

        while (k > 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1 && j == n - 1) {
                        arr[0][0] = grid[i][j];
                    } else if (j == n - 1) {
                        arr[i + 1][0] = grid[i][j];
                    } else {
                        arr[i][j + 1] = grid[i][j];
                    }
                }
            }
            k--;
            for (int i = 0; i < m; i++) {
                grid[i] = Arrays.copyOfRange(arr[i], 0, n);
            }
        }

        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(arr[i][j]);
            }
            result.add(list);
        }
        return result;
    }

}
