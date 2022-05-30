package C295;

public class C6079 {
    public static void main(String[] args) {
        System.out.println(discountPrices("$100 $a1 $1 $as $25$", 28));
    }

    public static String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        int len = words.length;
        StringBuilder sb = new StringBuilder(len);

        for (String word : words) {
            if (word.lastIndexOf("$") != 0 || word.length() < 2) {
                sb.append(word).append(' ');
                continue;
            }

            if (word.indexOf(1) == '-') {
                sb.append(word).append(' ');
                continue;
            }

            boolean isDigit = true;
            for (char ch : word.substring(1).toCharArray()) {
                if (!Character.isDigit(ch)) {
                    isDigit = false;
                    break;
                }
            }

            if (!isDigit) {
                sb.append(word).append(' ');
                continue;
            }
            //int value = Integer.parseInt(word.substring(1));
            long value = Long.parseLong(word.substring(1));
            sb.append('$').append(String.format("%.2f", value * ((100 - discount) * 0.01))).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
