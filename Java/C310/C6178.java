package C310;

import java.util.*;

public class C6178 {
    public static void main(String[] args) {
        System.out.println(minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}}));
        System.out.println(minGroups(new int[][]{{1, 3}, {5, 6}, {8, 10}, {11, 13}}));
        System.out.println(minGroups(new int[][]{{441459, 446342}, {801308, 840640}, {871890, 963447}, {228525, 336985}, {807945, 946787}, {479815, 507766}, {693292, 944029}, {751962, 821744}}));
    }

    public static int minGroups(int[][] intervals) {
        int len = intervals.length, result = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        for (int i = 1; i < len; i++) {
            if (queue.peek() >= intervals[i][0]) {
                queue.add(intervals[i][1]);
            } else {
                queue.poll();
                queue.add(intervals[i][1]);
            }
        }

        return queue.size();
    }
}
