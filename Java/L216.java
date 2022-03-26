import java.util.ArrayList;
import java.util.List;

public class L216 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<List<Integer>> result = combinationSum3(6, 30);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.printf("执行耗时：%dms", endTime - startTime);
    }

    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTracing(k, n, 0, 1);
        return result;
    }

    static List<Integer> item = new ArrayList<>();
    public static void backTracing(int k, int n, int sum, int startIndex) {
        if (item.size() == k) {
            if (sum == n) result.add(new ArrayList<>(item));
            return;
        }

        for (int i = startIndex; i <= Math.min(n - sum, 9); i++) {
            item.add(i);
            backTracing(k, n, sum + i, i + 1);
            item.remove(item.size() - 1);
        }
    }
}
