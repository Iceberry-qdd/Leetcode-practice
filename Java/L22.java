import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L22 {
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }

    static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        backTracing(n, n);
        return result;
    }

    static StringBuilder sb = new StringBuilder();

    public static void backTracing(int count1, int count2) {
        if (count1 == 0 && count2 == 0) {
            result.add(sb.toString());
        }

        if (count1 > 0) {
            sb.append('(');
            backTracing(count1 - 1, count2);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (count2 > count1) {
            sb.append(')');
            backTracing(count1, count2 - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
