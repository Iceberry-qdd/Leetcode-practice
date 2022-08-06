public class L2000 {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }

    public static String reversePrefix(String word, char ch) {
        char[] words = word.toCharArray();
        int len = words.length, left = 0, right = -1;
        for (int i = 0; i < len; i++) {
            if (words[i] == ch) {
                right = i;
                break;
            }
        }

        while (left < right) {
            char temp = words[right];
            words[right] = words[left];
            words[left] = temp;
            left++;
            right--;
        }

        return String.valueOf(words);
    }
}
