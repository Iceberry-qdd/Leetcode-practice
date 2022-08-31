public class L1455 {
    public static void main(String[] args) {

    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int len = words.length, result = -1;
        for (int i = 0; i < len; i++) {
            if (words[i].startsWith(searchWord)) {
                result = i;
                return result + 1;
            }
        }
        return result;
    }
}
