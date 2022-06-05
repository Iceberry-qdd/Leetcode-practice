package C296;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class C6092 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        int[][] operations = {{1, 3}, {4, 7}, {6, 1}};
        int[] result = arrayChange(nums, operations);
        System.out.println(Arrays.toString(result));

        nums = new int[]{1, 2};
        operations = new int[][]{{1, 3}, {2, 1}, {3, 2}};
        result = arrayChange(nums, operations);
        System.out.println(Arrays.toString(result));
    }

    public static int[] arrayChange(int[] nums, int[][] operations) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        int oLen = operations.length;
        for (int i = 0; i < oLen; i++) {
            Integer preIndex = map.remove(operations[i][0]);
            nums[preIndex] = operations[i][1];
            map.put(operations[i][1], preIndex);
        }
        return nums;
    }
}
