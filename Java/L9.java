public class L9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(123456));
        System.out.println(isPalindrome(-12321));
        System.out.println(isPalindrome(345696543));
        System.out.println(isPalindrome(11));
    }

    public static boolean isPalindrome(int x) {
        String chs = String.valueOf(x);
        int len = chs.length();

        if (len == 1) return true;
        //if (x > 0 && len % 2 == 0) return false;
        //if (x < 0 && (len - 1) % 2 == 0) return false;
        if (chs.charAt(0) == '-') return false;

        int left = 0, right = len - 1;
        while (left < right) {
            if (chs.charAt(left) == chs.charAt(right)) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }
}
