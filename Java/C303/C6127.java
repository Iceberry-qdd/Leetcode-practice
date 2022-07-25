package C303;

import java.util.ArrayList;
import java.util.List;

public class C6127 {
    public static void main(String[] args) {

    }

    public static long countExcellentPairs(int[] nums, int k) {
        int len = nums.length;
        long result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (verified(list, nums[i], nums[j], k)) {
                    result += i == j ? 1 : 2;
                }
            }
        }
        return result;
    }

    public static boolean verified(List<Integer> nums, int num1, int num2, int k) {
        if (!nums.contains(num1) || !nums.contains(num2)) return false;
        int bit1Count = bit1Count(bit1Count(num1 | num2)) + bit1Count(num1 & num2);
        if (bit1Count < k) return false;
        return true;
    }

    public static int bit1Count(int num) {
        int result = 0, i = 0;
        while ((num >> i) > 0) {
            if (((num >> i) ^ 1) == 1) result++;
            i++;
        }
        return result;
    }
}
