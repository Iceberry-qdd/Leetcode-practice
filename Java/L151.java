import java.util.ArrayList;
import java.util.List;

public class L151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good    example"));
        System.out.println(reverseWords("an good boy"));
        System.out.println(reverseWords("  Bob    Loves  Alice   "));
        System.out.println(reverseWords("Alice does not even like bob"));
        System.out.println(reverseWords("a"));
        //System.out.println(reverseWords("  "));
    }

    public static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        int len = s.length(), i;

        for (i = len - 1; i >= 0; i--) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            //while (i >= 0 && s.charAt(i) == ' ' && words.size() == 0) i--;
            //while (i >= 0 && s.charAt(i) == ' ' && words.size() != 0) i--;
            if (i < 0) break;
            int left = i, right = i;
            while (left >= 0 && s.charAt(left) != ' ') left--;
            words.add(s.substring(left + 1, right + 1));
            i = left;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
