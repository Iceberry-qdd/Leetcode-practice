import java.util.*;

public class L532 {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0));
    }

    public static int findPairs(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i] + k)) {
                int min = Math.min(nums[i], k + nums[i]), max = Math.max(nums[i], k + nums[i]);
                if (min == max && map.get(min) < 2) continue;
                set.add(String.format("%d_%d", min, max));
            }
            if (map.containsKey(nums[i] - k)) {
                int min = Math.min(nums[i], nums[i] - k), max = Math.max(nums[i], nums[i] - k);
                if (min == max && map.get(min) < 2) continue;
                set.add(String.format("%d_%d", min, max));
            }
        }
        return set.size();
    }
}
