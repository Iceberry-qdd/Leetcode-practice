import java.util.ArrayList;
import java.util.List;

public class L78 {
    public static void main(String[] args) {
        int[] nums = {0};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backTracing(nums, 0);
        return result;
    }

    static List<Integer> item = new ArrayList<>();

    public static void backTracing(int[] nums, int startIndex) {
        result.add(new ArrayList<>(item));
        int len = nums.length;
        if (startIndex >= len) return;

        for (int i = startIndex; i < len; i++) {
            item.add(nums[i]);
            backTracing(nums, i + 1);
            item.remove(item.size() - 1);
        }
    }
}
