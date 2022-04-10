public class L780 {
    public static void main(String[] args) {
        System.out.println(reachingPoints(1, 1, 3, 5));
        System.out.println(reachingPoints(1, 1, 2, 2));
        System.out.println(reachingPoints(1, 1, 1, 1));
        System.out.println(reachingPoints(1, 1, 3, 6));
        System.out.println(reachingPoints(2, 7, 9, 16));

        long start = System.currentTimeMillis();
        System.out.println(reachingPoints(1, 11, 999999991, 11));
        long end = System.currentTimeMillis();
        System.out.printf("> 执行耗时：%dms\n", end - start);

    }

    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx || ty >= sy) {
            if (tx == sx && ty == sy) return true;
            if (tx == ty) return false;
            if (tx - ty > 0) {
                tx = tx - ty * Math.max((tx - sx) / ty, 1);
            } else if (ty - tx > 0) {
                ty = ty - tx * Math.max((ty - sy) / tx, 1);
            }
        }
        return false;
    }
}
