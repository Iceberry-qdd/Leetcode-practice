package C288;

public class C6038 {
    public static void main(String[] args) {
        System.out.println(minimizeResult("247+38"));
        System.out.println(minimizeResult("12+34"));
        System.out.println(minimizeResult("999+999"));
        System.out.println(minimizeResult("99999999+9"));
        System.out.println(minimizeResult("9+29"));



    }

    public static String minimizeResult(String expression) {
        int len = expression.length();

        int index = expression.indexOf("+");
        int minValue = Integer.MAX_VALUE;
        String result = "";

        StringBuilder sb = new StringBuilder(expression);
        for (int i = 0; i < index; i++) {
            sb.insert(i, '(');
            for (int j = len + 1; j > index + 2; j--) {
                sb.insert(j, ')');
                int value = calc(sb.toString());
                if (value < minValue) {
                    minValue = value;
                    result = sb.toString();
                }
                sb.deleteCharAt(j);
            }
            sb.deleteCharAt(i);
        }
        return result;
    }

    public static int calc(String expression) {
        StringBuilder sb = new StringBuilder();
        int firstNum = 1, lastNum = 1, midNum1 = 0, midNum2 = 0;
        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                if (expression.indexOf(ch) == 0) continue;
                firstNum = Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
            } else if (ch == '+') {
                midNum1 = Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
            } else if (ch == ')') {
                midNum2 = Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
            } else sb.append(ch);
        }
        if (sb.length()>0){
            lastNum = Integer.parseInt(sb.toString());
        }
        return firstNum * (midNum1 + midNum2) * lastNum;
    }
}
