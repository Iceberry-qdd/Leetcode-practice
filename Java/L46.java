import java.util.ArrayList;
import java.util.List;

public class L46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backTracing(nums, used);
        return result;
    }

    static List<Integer> item = new ArrayList<>();

    public static void backTracing(int[] nums, boolean[] used) {
        int len = nums.length;

        if (item.size() == len) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i] == true) continue;
            item.add(nums[i]);
            used[i] = true;
            backTracing(nums, used);
            item.remove(item.size() - 1);
            used[i] = false;
        }
    }
}
