public class L777 {
    public static void main(String[] args) {

    }

    public static boolean canTransform(String start, String end) {
        int len = start.length();
        int i = 0, j = 0;
        while (true) {
            while (i < len && start.charAt(i) == 'X') i++;
            while (j < len && end.charAt(j) == 'X') j++;
            if (i >= len && j >= len) return true;
            if (i >= len || j >= len) return false;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
    }
}
