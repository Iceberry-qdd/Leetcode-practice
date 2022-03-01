public class L844 {
    public static void main(String[] args) {
        assert backspaceCompare("ab#c", "ad#c");
        assert backspaceCompare("ab##", "c#d#");
        assert !backspaceCompare("a#c", "b");
        assert backspaceCompare("bxj##tw", "bxo#j##tw");
        assert backspaceCompare("y#fo##f", "y#f#o##f");
    }

    public static boolean backspaceCompare(String s, String t) {
        int skipS = 0, skipT = 0, i = s.length() - 1, j = t.length() - 1;
        while (true) {
            for (; i >= 0; i--) {
                if (s.charAt(i) == '#') {
                    skipS++;
                } else if (skipS > 0) {
                    skipS--;
                } else break;
            }
            for (; j >= 0; j--) {
                if (t.charAt(j) == '#') {
                    skipT++;
                } else if (skipT > 0) {
                    skipT--;
                } else break;
            }
            if (i < 0 || j < 0) break;
            if (s.charAt(i) != t.charAt(j)) return false;
            i--; j--;
        }
        return i == -1 && j == -1;
    }
}
