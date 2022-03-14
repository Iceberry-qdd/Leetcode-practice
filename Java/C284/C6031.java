package C284;

import java.util.ArrayList;
import java.util.List;

public class C6031 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 9, 1, 3, 9, 5};
        int key = 9, k = 1;
        System.out.println(findKDistantIndices(nums, key, k));
        nums = new int[]{2, 2, 2, 2, 2};
        k = 2;
        key = 2;
        System.out.println(findKDistantIndices(nums, key, k));
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int len = nums.length;
        List<Integer> keyIndex = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            if (nums[i] == key) {
                keyIndex.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (Integer index : keyIndex) {
                if (Math.abs(i - index) <= k) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }
}
