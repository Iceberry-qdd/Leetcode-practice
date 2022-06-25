public class L1108 {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
    }

    public static String defangIPaddr(String address) {
        int len = address.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else sb.append(address.charAt(i));
        }
        return sb.toString();
    }
}
