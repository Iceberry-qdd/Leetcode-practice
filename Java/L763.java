import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L763 {
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(str);
        System.out.println(result);
    }

    public static List<Integer> partitionLabels(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int lastClipIndex = 0, endClipIndex = -1;

        for (int i = 0; i < len; i++) {
            endClipIndex = Math.max(map.get(s.charAt(i)), endClipIndex);
            if (i == endClipIndex) {
                result.add(i - lastClipIndex + 1);
                lastClipIndex = i + 1;
            }
        }
        return result;
    }
}
