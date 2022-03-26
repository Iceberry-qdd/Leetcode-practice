import java.util.Arrays;

public class L661 {
    public static void main(String[] args) {
        int[][] img = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        int[][] result = imageSmoother(img);
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] imageSmoother(int[][] img) {
        int rowLen = img.length, colLen = img[0].length;
        int[][] result = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                result[i][j] = calcAvg(img, new int[]{i, j});
            }
        }
        return result;
    }

    public static int calcAvg(int[][] arr, int[] midPoint) {
        int rowLen = arr.length, colLen = arr[0].length;
        int sum = 0, count = 0;
        for (int i = midPoint[0] - 1; i <= midPoint[0] + 1; i++) {
            for (int j = midPoint[1] - 1; j <= midPoint[1] + 1; j++) {
                if ((i >= 0 && i < rowLen) && (j >= 0 && j < colLen)) {
                    sum += arr[i][j];
                    count++;
                }
            }
        }
        return sum / count;
    }
}
