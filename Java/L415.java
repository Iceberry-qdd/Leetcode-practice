public class L415 {
    public static void main(String[] args) {
        String num1 = "11", num2 = "123";
        System.out.println(addStrings(num1, num2));

        num1 = "456";
        num2 = "77";
        System.out.println(addStrings(num1, num2));

        num1 = "0";
        num2 = "0";
        System.out.println(addStrings(num1, num2));

        num1 = "999";
        num2 = "1";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length(), len2 = num2.length();
        if (len1 > len2) return addStrings(num2, num1);

        int lastJinWei = 0, i, j;
        for (i = len1 - 1, j = len2 - 1; i >= 0 && j >= 0; i--, j--) {
            int intNum1 = Integer.parseInt(num1.substring(i, i + 1));
            int intNum2 = Integer.parseInt(num2.substring(j, j + 1));
            int curValue = intNum1 + intNum2 + lastJinWei;
            sb.append(curValue % 10);
            lastJinWei = curValue / 10;
        }

        while (j >= 0) {
            int intNum2 = Integer.parseInt(num2.substring(j, j + 1));
            int curValue = intNum2 + lastJinWei;
            sb.append(curValue % 10);
            lastJinWei = curValue / 10;
            j--;
        }

        if (lastJinWei > 0) sb.append(lastJinWei);
        return sb.reverse().toString();
    }
}
