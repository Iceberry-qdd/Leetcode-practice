import java.util.Arrays;

public class L824 {
    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public static final String VOWELS = "aeiouAEIOU";

    public static String toGoatLatin(String sentence) {
        String[] strArr = sentence.split(" ");
        int index = 1;
        StringBuilder resultSb = new StringBuilder();
        for (String s : strArr) {
            StringBuilder sb = new StringBuilder(s);
            if (VOWELS.contains(sb.substring(0, 1))) {
                sb.append("ma");
            } else {
                char firstChar = sb.charAt(0);
                sb.deleteCharAt(0)
                        .append(firstChar)
                        .append("ma");
            }

            int curIndex = index;
            while (curIndex > 0) {
                sb.append('a');
                curIndex--;
            }
            index++;
            resultSb.append(sb).append(' ');
        }

        resultSb.deleteCharAt(resultSb.length() - 1);
        return resultSb.toString();
    }
}
