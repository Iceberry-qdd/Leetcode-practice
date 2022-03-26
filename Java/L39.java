import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracing(candidates, target, 0, 0);
        return result;
    }

    static List<Integer> item = new ArrayList<>();

    public static void backTracing(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(item));
            return;
        }

        int len = candidates.length;
        for (int i = startIndex; i < len && sum + candidates[i] <= target; i++) {
            item.add(candidates[i]);
            backTracing(candidates, target, sum + candidates[i], i);
            item.remove(item.size() - 1);
        }
    }
}
