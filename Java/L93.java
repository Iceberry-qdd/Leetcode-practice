import java.util.ArrayList;
import java.util.List;

public class L93 {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> result = restoreIpAddresses(s);
        System.out.println(result);

        result.clear();
        s = "0000";
        result = restoreIpAddresses(s);
        System.out.println(result);

        result.clear();
        s = "101023";
        result = restoreIpAddresses(s);
        System.out.println(result);
    }

    static List<String> result = new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
        backTracing(s, 0, 0, 0);
        return result;
    }

    static StringBuilder sb = new StringBuilder();
    public static void backTracing(String s, int startIndex, int partCount, int endIndex) {
        int len = s.length();
        if (partCount == 4 && endIndex == len) {
            String item = sb.toString();
            result.add(item.substring(1));
            return;
        }
        if (partCount == 4 && endIndex < len) {
            return;
        }

        for (int i = startIndex; i < len; i++) {
            String curPart = s.substring(startIndex, i + 1);
            if (curPart.charAt(0) == '0' && curPart.length() > 1) return;
            int curPartNum = Integer.parseInt(curPart);
            if (curPartNum >= 0 && curPartNum <= 255) {
                sb.append('.').append(curPart);
            } else return;
            backTracing(s, i + 1, partCount + 1, i + 1);
            sb.delete(sb.lastIndexOf("."), sb.length());
        }
    }
}
