public class L917 {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters("7_28]"));
    }

    public static String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < len && !Character.isAlphabetic(arr[left])) left++;
            while (right >= 0 && !Character.isAlphabetic(arr[right])) right--;
            //if (left >= len || right < 0 || left >= right) break;
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(arr);
    }
}
