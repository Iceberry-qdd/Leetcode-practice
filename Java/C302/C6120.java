package C302;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C6120 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2})));
    }

    public static int[] numberOfPairs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length, pairCount = 0;
        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
                pairCount++;
            } else {
                set.add(nums[i]);
            }
        }
        return new int[]{pairCount, set.size()};
    }
}
