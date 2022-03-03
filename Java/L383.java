public class L383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("aab", "aab"));
        System.out.println(canConstruct("aabb", "aab"));
        System.out.println(canConstruct("aabc", "aabbd"));
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aab", "aabbb"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] alpha = new int[26];
        int lenR = ransomNote.length(), lenM = magazine.length();
        if (lenR > lenM) return false;
        for (int i = 0; i < lenM; i++) alpha[magazine.charAt(i) - 'a']++;
        for (int i = 0; i < lenR; i++) alpha[ransomNote.charAt(i) - 'a']--;
        for (int value : alpha)
            if (value < 0) return false;
        return true;
    }
}
