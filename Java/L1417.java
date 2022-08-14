import java.util.ArrayList;
import java.util.List;

public class L1417 {
    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));
        System.out.println(reformat("ab123"));
    }

    public static String reformat(String s) {
        int len = s.length();
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                list1.add(ch);
            } else {
                list2.add(ch);
            }
        }

        int len1 = list1.size(), len2 = list2.size();

        if (Math.abs(len1 - len2) > 1) {
            return "";
        } else {
            List<Character> temp;
            int tempLen;
            if (len1 < len2) {
                temp = list1;
                list1 = list2;
                list2 = temp;

                tempLen = len1;
                len1 = len2;
                len2 = tempLen;
            }
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0, j = 0, k = 0; i < len; i++) {
                if (j < len1) {
                    sb.append(list1.get(i));
                    j++;
                }
                if (k < len2) {
                    sb.append(list2.get(i));
                    k++;
                }
            }
            return sb.toString();
        }
    }
}
