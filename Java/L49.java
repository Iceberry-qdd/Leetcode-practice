import java.util.*;

public class L49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        strs = new String[]{"", "", "ab", "ba", ""};
        System.out.println(groupAnagrams(strs));
        strs = new String[]{"a"};
        System.out.println(groupAnagrams(strs));
//        Map<String,Integer> map=new HashMap<>();
//        map.put("abc",1);
//        String s="cba";
//        char[] chs=s.toCharArray();
//        Arrays.sort(chs);
//        String key= new String(chs);
//        System.out.println(map.containsKey(key));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] keyArr = str.toCharArray();
            Arrays.sort(keyArr);
            String key = new String(keyArr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

/*
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> Llist = new ArrayList<>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            if (strs[i].equals("*")) continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (int j = i + 1; j < len; j++) {
                if (strs[j].equals("*")) continue;
                if (isAnagram(strs[i], strs[j])) {
                    list.add(strs[j]);
                    strs[j] = "*";
                }
            }
            Llist.add(list);
            strs[i] = "";
        }
        return Llist;
    }

 */

    /*
    public static boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        int lenS = s.length(), lenT = t.length();
        if (lenS != lenT) return false;
        for (int i = 0; i < lenS; i++) alpha[s.charAt(i) - 'a']++;
        for (int i = 0; i < lenT; i++) alpha[t.charAt(i) - 'a']--;
        for (int value : alpha)
            if (value != 0) return false;
        return true;
    }

     */
}
