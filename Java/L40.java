import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40 {
    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracing(candidates, 0, target, 0);
        return result;
    }

    static List<Integer> item = new ArrayList<>();

    public static void backTracing(int[] cadidates, int sum, int target, int startIndex) {
        int len = cadidates.length;
        if (sum == target) {
            result.add(new ArrayList<>(item));
            return;
        }

        if (sum > target) return;

        for (int i = startIndex; i < len; i++) {
            if (i > startIndex && cadidates[i] == cadidates[i - 1]) continue;// 去重
            item.add(cadidates[i]);
            backTracing(cadidates, sum + cadidates[i], target, i + 1);
            item.remove(item.size() - 1);
        }
    }
}
