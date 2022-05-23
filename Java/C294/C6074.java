package C294;

public class C6074 {
    public static void main(String[] args) {

    }

    public static int percentageLetter(String s, char letter) {
        int len = s.length();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == letter) {
                count++;
            }
        }
        return (int) Math.floor(((count * 1.0) / len) * 100);
    }
}
