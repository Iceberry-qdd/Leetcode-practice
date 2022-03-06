public class L344 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s);
        s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        System.out.println(s);
        s = new char[]{'a'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
