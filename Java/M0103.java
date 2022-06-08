import java.util.Arrays;

public class M0103 {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
        System.out.println(replaceSpaces("               ", 5));
        System.out.println(replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }

    public static String replaceSpaces(String S, int length) {
        char[] s = S.toCharArray();
        int len = s.length, i, j;
        for (i = len - 1, j = length - 1; i >= 0 && j >= 0; i--) {
            if (s[j] != ' ') {
                s[i] = s[j];
            } else {
                s[i--] = '0';
                s[i--] = '2';
                s[i] = '%';
            }
            j--;
        }
        if (i == -1) return String.valueOf(s);
        else return String.valueOf(s, i + 1, len - i - 1);
    }

}
