import java.util.Arrays;

public class L498 {
    public static void main(String[] args) {
        int[] result = findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(result));
        result = findDiagonalOrder(new int[][]{{1, 2}, {3, 4}});
        System.out.println(Arrays.toString(result));
        result = findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(Arrays.toString(result));
        result = findDiagonalOrder(new int[][]{{1, 2}, {4, 5}, {7, 8}});
        System.out.println(Arrays.toString(result));
        result = findDiagonalOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        System.out.println(Arrays.toString(result));
        result = findDiagonalOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        System.out.println(Arrays.toString(result));
        result = findDiagonalOrder(new int[][]{{1}});
        System.out.println(Arrays.toString(result));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];

        int i = 0, j = 0, k = 0;
        boolean mode = true;
        while (k < m * n) {
            if (i < 0 && j >= n) {
                i += 2;
                j--;
                mode = false;
            } else if (j < 0 && i >= m) {
                j += 2;
                i--;
                mode = true;
            } else if (i < 0) {
                i = 0;
                mode = false;
            } else if (j < 0) {
                j = 0;
                mode = true;
            } else if (j >= n) {
                j = n - 1;
                i += 2;
                mode = false;
            } else if (i >= m) {
                j += 2;
                i = m - 1;
                mode = true;
            }

            if (mode) {
                result[k++] = mat[i--][j++];
            } else {
                result[k++] = mat[i++][j--];
            }

        }
        return result;
    }
}
