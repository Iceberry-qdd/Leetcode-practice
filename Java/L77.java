import java.util.ArrayList;
import java.util.List;

public class L77 {
    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        System.out.println(result);
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backTracing(n, k, 1);
        return result;
    }

    static List<Integer> item = new ArrayList<>();

    public static void backTracing(int n, int k, int startIndex) {
        if (item.size() == k) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            item.add(i);
            backTracing(n, k, i + 1);
            item.remove(item.size() - 1);
        }
    }
}
