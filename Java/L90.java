import java.util.*;

public class L90 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracing(nums, 0);
        return result;
    }

    static List<Integer> item = new ArrayList<>();

    public static void backTracing(int[] nums, int startIndex) {
        int len = nums.length;
        result.add(new ArrayList<>(item));
        Set<Integer> set = new HashSet<>();

        for (int i = startIndex; i < len; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);

            item.add(nums[i]);
            backTracing(nums, i + 1);
            item.remove(item.size() - 1);
        }
    }
}
