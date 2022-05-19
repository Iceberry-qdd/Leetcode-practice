public class L812 {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println(largestTriangleArea(points));
    }

    public static double largestTriangleArea(int[][] points) {
        int len = points.length;
        double result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int x1 = points[i][0] - points[j][0];
                int y1 = points[i][1] - points[j][1];
                for (int k = j + 1; k < len; k++) {
                    int x2 = points[i][0] - points[k][0];
                    int y2 = points[i][1] - points[k][1];
                    result = Math.max(result, Math.abs(x1 * y2 - x2 * y1));
                }
            }
        }
        return result / 2;
    }
}
