import java.util.Arrays;

public class L435 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));

        intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        System.out.println(eraseOverlapIntervals(intervals));

        intervals = new int[][]{{1, 2}, {2, 3}};
        System.out.println(eraseOverlapIntervals(intervals));

        intervals = new int[][]{{1,2},{2,3},{3,4},{-100,-2},{5,7}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int  len = intervals.length;
        if (len==0) return 0;
        int result = 1,lastEnd = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= lastEnd) {
                result++;
                lastEnd = intervals[i][1];
            }
        }
        return len - result;
    }
}
