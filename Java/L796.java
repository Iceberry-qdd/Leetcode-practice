public class L796 {
    public static void main(String[] args) {
        String s="abcde",goal="cdeab";
        System.out.println(rotateString(s,goal));
    }

    public static boolean rotateString(String s, String goal) {
        return (s+s).contains(goal);
    }
}
