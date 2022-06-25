import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L30 {
    public static void main(String[] args) {
        List<Integer> result = findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(result);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length(), sLen = s.length(), wordCount = words.length;
        List<Integer> result = new ArrayList<>();
        if (sLen < wordLen * wordCount) return result;
        HashMap<String, Integer> map = new HashMap<>(wordCount);

        for (int i = 0; i < wordCount; i++) {
            map.merge(words[i], 1, Integer::sum);
        }

        int left = 0, right = wordLen * wordCount - 1;
        while (right < sLen) {
            HashMap<String, Integer> mapBackup = new HashMap<>(map);
            int i = left, j = i + wordLen - 1;
            while (j <= right) {
                String curWord = s.substring(i, j + 1);
                if (mapBackup.containsKey(curWord) && mapBackup.get(curWord) > 1) {
                    mapBackup.merge(curWord, -1, Integer::sum);
                } else if (mapBackup.containsKey(curWord) && mapBackup.get(curWord) == 1) {
                    mapBackup.remove(curWord);
                } else break;
                i = j + 1;
                j += wordLen;
            }
            if (mapBackup.size() == 0) result.add(left);
            left++;
            right++;
        }
        return result;
    }
}
