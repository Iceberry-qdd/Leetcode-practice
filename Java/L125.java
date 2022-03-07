public class L125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("  "));
        System.out.println(isPalindrome(".,"));
        System.out.println(isPalindrome("0P"));

    }

    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int len = s.length();
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < len && !Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left)))
                left++;

            while (right >= 0 && !Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right)))
                right--;

            if (left == len && right == -1) return true;
            if (left == len || right == -1) return false;
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
                continue;
            }else return false;

//            boolean flag1 = s.charAt(left) == s.charAt(right);
//            boolean flag2 = s.charAt(left) - 'A' + 'a' == s.charAt(right);
//            boolean flag3 = s.charAt(left) - 'a' + 'A' == s.charAt(right);
//            if (flag1 || flag2 || flag3) {
//                left++;
//                right--;
//            } else return false;
        }
        return true;
    }
}
