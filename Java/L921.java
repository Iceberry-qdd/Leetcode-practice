public class L921 {
    public static void main(String[] args) {

    }

    public static int minAddToMakeValid(String s) {
        int len = s.length(), needLeft = 0, needRight = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') needRight++;
            else {
                if (needRight == 0) needLeft++;
                else needRight--;
            }
        }
        return needLeft + needRight;
    }
}
