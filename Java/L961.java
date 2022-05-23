import java.util.HashMap;
import java.util.Map;

public class L961 {
    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{1, 2, 3, 3}));
    }

    public static int repeatedNTimes(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.merge(nums[i], 1, Integer::sum);
            if (map.get(nums[i]) == len / 2) return nums[i];
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == len / 2) return key;
        }
        return 0;
    }
}
