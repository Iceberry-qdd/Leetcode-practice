import java.util.*;

public class L1002 {
    public static void main(String[] args) {
        List<String> result = commonChars(new String[]{"bella", "label", "roller"});
        System.out.println(result);
        result = commonChars(new String[]{"cool", "lock", "cook"});
        System.out.println(result);

        result = commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"});
        System.out.println(result);
    }

    public static List<String> commonChars(String[] words) {
        int len = words.length;
        int[] newHash = new int[26];
        Arrays.fill(newHash, 101);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int[] hash = new int[26];
            int curLen = word.length();
            for (int j = 0; j < curLen; j++) {
                hash[word.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                newHash[j] = Math.min(hash[j], newHash[j]);
            }
        }

        for (int i = 0; i < 26; i++) {
            int count = newHash[i];
            while (count > 0) {
                result.add(String.format("%c", i + 'a'));
                count--;
            }
        }

        return result;
    }
}
