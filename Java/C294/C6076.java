package C294;

import java.math.BigDecimal;
import java.util.Arrays;

public class C6076 {
    public static void main(String[] args) {
        System.out.println(minimumLines(new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}}));
        System.out.println(minimumLines(new int[][]{{3, 4}, {1, 2}, {7, 8}, {2, 3}}));
        System.out.println(minimumLines(new int[][]{{83, 35}, {79, 51}, {61, 48}, {54, 87}, {44, 93}, {22, 5}, {87, 28}, {64, 8}, {89, 78}, {62, 83}, {58, 72}, {48, 7}, {97, 16}, {27, 100}, {65, 48}, {11, 31}, {29, 76}, {93, 29}, {72, 59}, {73, 74}, {9, 90}, {66, 81}, {12, 8}, {86, 80}, {84, 43}, {36, 63}, {80, 45}, {81, 88}, {95, 5}, {40, 59}}));
    }

    public static int minimumLines(int[][] stockPrices) {
        int len = stockPrices.length, result = 1;
        if (len < 2) return 0;
        if (len == 2) return 1;

        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);

        int[] nextExcept = calcNextExceptPoint(stockPrices[0], stockPrices[1], stockPrices[2][0]);

        for (int i = 2; i < len; i++) {
            if (stockPrices[i][0] != nextExcept[0] || stockPrices[i][1] != nextExcept[1] || nextExcept[2] == 0) {
                result++;
            }
            if (i == len - 1) break;
            nextExcept = calcNextExceptPoint(stockPrices[i - 1], stockPrices[i], stockPrices[i + 1][0]);
        }
        return result;
    }

    public static int[] calcNextExceptPoint(int[] point1, int[] point2, int nextPointX) {
        int x1 = point1[0], y1 = point1[1], x2 = point2[0], y2 = point2[1];

        int x3 = nextPointX;
        int y3 = (((x3 - x1) * (y2 - y1)) / (x2 - x1)) + y1;
        double temp_y = (((x3 - x1) * 1.0 * (y2 - y1)) / (x2 - x1)) + y1;
        if (new BigDecimal(temp_y).compareTo(new BigDecimal(y3)) == 0)
            return new int[]{x3, y3, 1};
        else return new int[]{x3, y3, 0};
    }
}
