import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] result = merge(intervals);
        System.out.println(Arrays.deepToString(result));

        intervals = new int[][]{{1, 4}, {4, 5}};
        result = merge(intervals);
        System.out.println(Arrays.deepToString(result));

        intervals = new int[][]{{1, 3}, {8, 16}, {2, 6}, {15, 18}};
        result = merge(intervals);
        System.out.println(Arrays.deepToString(result));

        intervals = new int[][]{{1, 4}, {2, 3}};
        result = merge(intervals);
        System.out.println(Arrays.deepToString(result));

        intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        result = merge(intervals);
        System.out.println(Arrays.deepToString(result));

        intervals = new int[][]{{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}};
        result = merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] <= intervals[i - 1][1] || intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                result.add(new int[]{start, end});
                end = Math.max(intervals[i][1], end);
                start = intervals[i][0];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }
}
