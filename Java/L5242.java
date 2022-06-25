public class L5242 {
    public static void main(String[] args) {

    }

    public static String greatestLetter(String s) {
        int[] upperAlpha = new int[26], lowerAlpha = new int[26];
        int len = s.length();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (Character.isUpperCase(sArray[i])) upperAlpha[sArray[i] - 'A']++;
            else lowerAlpha[sArray[i] - 'a']++;
        }

        String result = "";
        for (int i = 25; i >= 0; i--) {
            if (upperAlpha[i] != 0 && lowerAlpha[i] != 0) {
                result = String.format("%c", i + 'A');
                break;
            }
        }
        return result;
    }
}
