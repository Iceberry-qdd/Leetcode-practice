import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17 {
    public static void main(String[] args) {
        String digits = "238";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
    }

    static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        backTracing(digits, 0);// index表示digits的下标
        return result;
    }

    static StringBuilder item = new StringBuilder();
    static Map<Integer, String> map = Map.of(
            1, "",
            2, "abc",
            3, "def",
            4, "ghi",
            5, "jkl",
            6, "mno",
            7, "pqrs",
            8, "tuv",
            9, "wxyz"
    );

    public static void backTracing(String digits, int index) {
        if (index == digits.length()) {
            result.add(item.toString());
            //item.delete(0, item.length());// 清空
            return;
        }

        int num = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String alphas = map.get(num);
        for (int i = 0; i < alphas.length(); i++) {
            item.append(alphas.charAt(i));
            backTracing(digits, index + 1);
            item.deleteCharAt(item.length() - 1);
        }
    }
}
