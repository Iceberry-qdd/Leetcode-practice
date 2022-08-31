import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L884 {
    public static void main(String[] args) {
        String[] result = uncommonFromSentences("s z z z s", "s z ejt");
        System.out.println(Arrays.toString(result));
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String str = s1 + " " + s2;
        String[] sArr = str.split(" ");
        for (String s : sArr) {
            map.merge(s, 1, Integer::sum);
        }

        int size = 0;
        for (Integer value : map.values()) {
            if (value == 1) size++;
        }

        String[] result = new String[size];
        int i = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == 1){
                result[i++] = key;
            }
        }
        return result;
    }
}
