import java.util.ArrayList;
import java.util.List;

public class L1408 {
    public static void main(String[] args) {
        List<String> result = stringMatching(new String[]{"mass", "as", "hero", "superhero"});
        System.out.println(result);
    }

    public static List<String> stringMatching(String[] words) {
        int len = words.length;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (result.contains(words[j])) continue;
                if (words[i].contains(words[j])) {
                    result.add(words[j]);
                }
            }
        }
        return result;
    }
}
