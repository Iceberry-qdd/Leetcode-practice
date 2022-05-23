package C294;

import java.util.Arrays;
import java.util.PriorityQueue;

public class C6075 {
    public static void main(String[] args) {
        int result = maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2);
        System.out.println(result);
    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int len = capacity.length, result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        //int[] restCapacity = new int[len];

        for (int i = 0; i < len; i++) {
            //restCapacity[i] = capacity[i] - rocks[i];
            queue.add(capacity[i] - rocks[i]);
        }

        //Arrays.sort(restCapacity);

        for (int i = 0; i < len; i++) {
            Integer curNum = queue.poll();
            if (curNum == null || additionalRocks <= 0 || additionalRocks < curNum) break;
            additionalRocks -= curNum;
            result++;
        }

        return result;
    }
}
