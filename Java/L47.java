import java.util.*;

public class L47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] used = new int[len];
        backTracing(nums, used);
        return result;
    }

    static List<Integer> item = new ArrayList<>();

    public static void backTracing(int[] nums, int[] used) {
        int len = nums.length;
        if (item.size() == len) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 1) continue;// 同一树层使用过，去重跳过
            if (used[i] == 1) continue;// 同一树枝使用过，跳过去重
            item.add(nums[i]);
            used[i] = 1;
            backTracing(nums, used);
            item.remove(item.size() - 1);
            used[i] = 0;
        }
    }
}
