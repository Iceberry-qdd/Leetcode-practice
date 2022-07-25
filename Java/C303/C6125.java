package C303;

import java.util.*;

public class C6125 {
    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        System.out.println(equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
    }

    public static int equalPairs(int[][] grid) {
        int n = grid.length, result = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.merge(Arrays.toString(grid[i]), 1, Integer::sum);
        }

        for (int i = 0; i < n; i++) {
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = grid[j][i];
            }
            if (map.containsKey(Arrays.toString(arr))) {
                result += map.get(Arrays.toString(arr));
            }
        }
        return result;
    }
}
