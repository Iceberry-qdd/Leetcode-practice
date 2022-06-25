public class L6099 {
    public static void main(String[] args) {
        System.out.println(longestSubsequence("0", 583196182));
        System.out.println(longestSubsequence("1001010", 5));
        System.out.println(longestSubsequence("00101001", 1));
        System.out.println(longestSubsequence("000101010011011001011101111000111111100001011000000100010000111100000011111001000111100111101001111001011101001011011101001011011001111111010011100011110111010000010000010111001001111101100001111", 300429827));
    }

    public static int longestSubsequence(String s, int k) {
        char[] sArray = s.toCharArray();
        int len = sArray.length, result = 0;
        for (int i = 0; i < len; i++) {
            if (sArray[i] == '0') result++;
        }

        int num = 0;
        //for (int i = 0; i <len; i++) {
        for (int i = len - 1; i > Math.max(0, len - 31); i--) {
            int temp = num + (1 << (len - i - 1));
            if (sArray[i] == '1') {
                if (num + (1 << (len - i - 1)) > k) break;
                result++;
                num += 1 << (len - i - 1);
            }
        }
        return result;
    }
}
