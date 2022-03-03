public class L242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram("a", "n"));
        System.out.println(isAnagram("anagram", "nagaramm"));
        System.out.println(isAnagram("anagramm", "nagaram"));
    }

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
}
