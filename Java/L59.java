import java.util.Arrays;

public class L59 {
    public static void main(String[] args) {
        System.out.println(5 >> 1);
        System.out.println(Arrays.deepToString(generateMatrix(1)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1,laps=0;
        int up = 0, down = 0, left = 0, right = 0;
        while (num <= n * n) {
            while (up < n - 1 - laps) {
                matrix[laps][up] = num;
                up++;
                num++;
            }

            while (right < n - 1 - laps) {
                matrix[right][n - 1 - laps] = num;
                right++;
                num++;
            }

            while (down < n - 1 - laps) {
                matrix[n - 1 - laps][n - 1 - down] = num;
                down++;
                num++;
            }

            while (left < n - 1 - laps) {
                matrix[n - 1 - left][laps] = num;
                left++;
                num++;
            }

            if (n % 2 != 0 && num == n * n) {
                matrix[n >> 1][n >> 1] = num;
                break;
            }

            laps++;
            up = down = left = right = laps;
        }
        return matrix;
    }
}
