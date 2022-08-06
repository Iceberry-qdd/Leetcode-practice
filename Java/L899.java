public class L899 {
    public static void main(String[] args) {
        System.out.println(orderlyQueue("cba", 1));
        System.out.println(orderlyQueue("baaca", 3));
    }

    public static String orderlyQueue(String s, int k) {
        int len = s.length();
        StringBuilder sb;
        if (k == 1) {
            String result = s;
            for (int i = 0; i < len; i++) {
                String s1 = s.substring(0, i + 1);
                String s2 = s.substring(i + 1, len);
                if (result.compareTo(s2 + s1) > 0) {
                    result = s2 + s1;
                }
            }
            return result;
        } else {
            sb = new StringBuilder();
            s.chars().sorted().forEach(ch -> sb.append((char) ch));
        }
        return sb.toString();
    }
}
