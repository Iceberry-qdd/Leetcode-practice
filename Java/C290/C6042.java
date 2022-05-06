package C290;

public class C6042 {
    public static void main(String[] args) {

        int[][] circles = {{2, 2, 2}, {3, 4, 1}};
        long startTime = System.currentTimeMillis();
        int result = countLatticePoints(circles);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.printf("执行耗时：%dms\n", endTime - startTime);

        circles = new int[][]{{8, 9, 6}, {9, 8, 4}, {4, 1, 1}, {8, 5, 1}, {7, 1, 1}, {6, 7, 5}, {7, 1, 1}, {7, 1, 1}, {5, 5, 3}};
        startTime = System.currentTimeMillis();
        result = countLatticePoints(circles);
        endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.printf("执行耗时：%dms\n", endTime - startTime);

        circles = new int[][]{{10, 7, 3}, {5, 9, 5}, {10, 4, 2}, {3, 8, 2}, {2, 3, 1}, {2, 10, 1}, {10, 9, 8}, {6, 6, 3}, {8, 6, 3}, {9, 8, 7}, {9, 4, 3}, {7, 4, 1}, {4, 6, 2}, {4, 3, 2}, {8, 3, 3}};
        startTime = System.currentTimeMillis();
        result = countLatticePoints(circles);
        endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.printf("执行耗时：%dms\n", endTime - startTime);
    }

    public static int countLatticePoints(int[][] circles) {
        int len = circles.length, result = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int k = 0; k < len; k++) {
                    int x = circles[k][0], y = circles[k][1], r = circles[k][2];
                    if ((i - x) * (i - x) + (j - y) * (j - y) <= r * r) {
                        result++;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
