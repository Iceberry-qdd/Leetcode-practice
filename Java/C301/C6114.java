package C301;

public class C6114 {
    public static void main(String[] args) {
        System.out.println(canChange("_L__R__R_", "L______RR"));
        System.out.println(canChange("R_L_", "__LR"));
        System.out.println(canChange("_R", "R_"));
        System.out.println(canChange("_L__R__R_L", "L______RR_"));
        System.out.println(canChange("_L__R__RL", "L_____RLR"));
        System.out.println(canChange("__", "__"));
    }

    public static boolean canChange(String start, String target) {
        int len = start.length();

        for (int i = 0, j = 0; i < len && j < len; i++, j++) {
            while (i < len && start.charAt(i) == '_') i++;
            while (j < len && target.charAt(j) == '_') j++;

            if (i == len && j == len) continue;
            if (i == len || j == len) return false;

            if (start.charAt(i) != target.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
        }
        return true;
    }

    public static String realStr(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != '_') {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
