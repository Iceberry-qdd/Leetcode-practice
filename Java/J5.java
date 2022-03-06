public class J5 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
        System.out.println(replaceSpace(""));
        System.out.println(replaceSpace("     "));
        System.out.println(replaceSpace(" a b s c d "));
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
//            if (s.charAt(i) == ' ') {
//                sb.append("%20");
//            } else {
//                sb.append(s.charAt(i));
//            }
            sb.append((s.charAt(i) == ' ') ? "%20" : s.charAt(i));
        }
        return sb.toString();
        //char[] arr=s.toCharArray();
//        int len=arr.length;
//        for (int i = 0; i < len; i++) {
//            if (arr[i]==' '){
//                arr[i]=
//            }
//        }
    }
}
