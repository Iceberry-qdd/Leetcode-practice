public class L1037 {
    public static void main(String[] args) {
        System.out.println(isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        System.out.println(isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }

    public static boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];

        if (x1 == x2 && y1 == y2) return false;
        if (x1 == x3 && y1 == y3) return false;
        if (x2 == x3 && y2 == y3) return false;

        if (x1 == x2) return !(x3 == x1);
        if (y1 == y2) return !(y3 == y1);

        return !((y3 - y1) * (x2 - x1) == (y2 - y1) * (x3 - x1));
    }
}
