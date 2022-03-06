import java.util.HashMap;
import java.util.Map;

public class L454 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, -1, 0}, nums2 = {-2, -1, 1, 2}, nums3 = {-1, 2, 0, 1}, nums4 = {0, 2, 1, -1};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums1.length, sum, count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum = nums1[i] + nums2[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else map.put(sum, 1);
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum = 0 - nums3[i] - nums4[j];
                if (map.containsKey(sum)) {
                    count += map.get(sum);
                }
            }
        }
        return count;
    }
}
