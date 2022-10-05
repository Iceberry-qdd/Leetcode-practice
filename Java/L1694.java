public class L1694 {
    public static void main(String[] args) {
        System.out.println(reformatNumber("1-23-45-6"));
        System.out.println(reformatNumber("123 4-567"));
        System.out.println(reformatNumber("123 4-5678"));
        System.out.println(reformatNumber("12"));
        System.out.println(reformatNumber("--17-5 229 35-39475"));
    }

    public static String reformatNumber(String number) {
        int len = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : number.toCharArray()) {
            if (ch != ' ' && ch != '-') {
                sb.append(ch);
                len++;
            }
        }

        number = sb.toString();
        sb.delete(0, len);

        for (int i = 0; i < len; i++) {
            if (len % 3 == 0 || len - i > 4) {
                sb.append(number.charAt(i));
                if ((i + 1) % 3 == 0 && i != len - 1) sb.append('-');
            } else {
                if (len - i == 4) {
                    sb.append(number.charAt(i))
                            .append(number.charAt(i + 1))
                            .append('-')
                            .append(number.charAt(i + 2))
                            .append(number.charAt(i + 3));
                } else {
                    sb.append(number.charAt(i))
                            .append(number.charAt(i + 1));
                }
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
