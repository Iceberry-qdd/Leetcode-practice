import java.util.*;
import java.util.stream.Stream;

public class L819 {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[^a-zA-Z]+");
        int len = words.length;
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String curLowerCaseWord = words[i].toLowerCase();
            if (!set.contains(curLowerCaseWord)) {
                map.merge(curLowerCaseWord, 1, Integer::sum);
            }
        }

        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
