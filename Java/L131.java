import java.util.ArrayList;
import java.util.List;

public class L131 {
    public static void main(String[] args) {
        List<List<String>> result = partition("aab");
        System.out.println(result);

        result = partition("a");
        System.out.println(result);
    }

    static List<List<String>> result = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        backTracing(s, 0);
        return result;
    }

    static List<String> item = new ArrayList<>();

    public static void backTracing(String str, int startIndex) {
        int len = str.length();
        if (startIndex >= len) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = startIndex; i < len; i++) {
            boolean isHuiwen = isHuiwen(str, startIndex, i);
            if (!isHuiwen) continue;
            item.add(str.substring(startIndex, i + 1));
            backTracing(str, i + 1);
            item.remove(item.size() - 1);
        }
    }

    public static boolean isHuiwen(String str, int begin, int end) {
        int len = str.length();
        if (begin >= len) return false;
        while (begin <= end) {
            if (str.charAt(begin) != str.charAt(end)) return false;
            begin++;
            end--;
        }
        return true;
    }
}
