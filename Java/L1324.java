import java.util.ArrayList;
import java.util.List;

public class L1324 {
    public static void main(String[] args) {
        List<String> result = printVertically("HOW ARE YOU");
        System.out.println(result);

        result = printVertically("TO BE OR NOT TO BE");
        System.out.println(result);

        result = printVertically("CONTEST IS COMING");
        System.out.println(result);
    }

    public static List<String> printVertically(String s) {
        //s = s.split(" ", -1)[0];
        String[] sArr = s.split(" ");
        int colLen = 0, maxRowLen = sArr.length;
        for (int i = 0; i < maxRowLen; i++) {
            colLen = Math.max(colLen, sArr[i].length());
        }

        List<String> result = new ArrayList<>(maxRowLen);
        for (int i = 0; i < colLen; i++) {
            StringBuilder sb = new StringBuilder();
            //boolean flag = false;
            for (int j = 0; j < maxRowLen; j++) {
                if (sArr[j].length() <= i/* && flag == false*/) {
                    sb.append(" ");
                } else if (sArr[j].length() > i) {
                    sb.append(sArr[j].charAt(i));
                    /*flag=true;*/
                }
            }

            for (int j = maxRowLen - 1; j >= 0; j--) {
                if (sb.charAt(j) != ' ') break;
                else {
                    sb.deleteCharAt(j);
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}
