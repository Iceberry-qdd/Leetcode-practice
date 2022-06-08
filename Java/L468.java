public class L468 {
    public static void main(String[] args) {
        String[] testIp = {
                "12..33.4",
                "2001:0db8:85a3:0:0:8A2E:0370:7334:",
                "172.16.254.1",
                "2001:0db8:85a3:0:0:8A2E:0370:7334",
                "256.256.256.256",
                "192.168.01.1",
                "192.168.1.00",
                "192.168@.1.1",
                "2001:db8:85a3:0:0:8A2E:0370:7334",
                "2001:0db8:85a3::8A2E:037j:7334",
                "02001:0db8:85a3:0000:0000:8a2e:0370:7334",
                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"};
        for (String ip : testIp) {
            System.out.println(validIPAddress(ip));
        }
    }

    public static String validIPAddress(String queryIP) {
        if (queryIP.isBlank() || queryIP.isEmpty()) return "Neither";
        else if (isIPv4(queryIP)) return "IPv4";
        else if (isIPv6(queryIP)) return "IPv6";
        else return "Neither";
    }

    private static boolean isIPv6(String queryIP) {
        for (char ch : queryIP.toCharArray()) {
            ch = Character.toLowerCase(ch);
            if (!Character.isDigit(ch) && !(ch >= 'a' && ch <= 'f') && ch!=':') return false;
        }

        if (queryIP.charAt(queryIP.length() - 1) == ':') return false;

        String[] splitIp = queryIP.split(":");
        int len = splitIp.length;
        if (len != 8) return false;

        for (int i = 0; i < len; i++) {
            if (splitIp[i].length() > 4 || splitIp[i].length() < 1) return false;
        }
        return true;
    }

    private static boolean isIPv4(String queryIP) {
        for (char ch : queryIP.toCharArray()) {
            if (!Character.isDigit(ch) && ch != '.') return false;
        }

        if (queryIP.charAt(queryIP.length() - 1) == '.') return false;

        String[] splitIp = queryIP.split("\\.");
        int len = splitIp.length;
        if (len != 4) return false;

        for (int i = 0; i < len; i++) {
            if (splitIp[i].startsWith("0") && splitIp[i].length() > 1) {
                return false;
            }

            try {
                int num = Integer.parseInt(splitIp[i]);
                if (num < 0 || num > 255) return false;
            }catch (NumberFormatException e){
                return false;
            }

        }
        return true;
    }
}