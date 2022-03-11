import java.util.ArrayDeque;
import java.util.Deque;

public class L150 {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
        tokens=new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
        tokens=new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        int len = tokens.length;
        if (len==1) return Integer.parseInt(tokens[0]);
        Deque<String> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            while (!isOpt(tokens[i])) stack.push(tokens[i++]);
            int nums1 = Integer.parseInt(stack.pop());
            int nums2 = Integer.parseInt(stack.pop());

            switch (tokens[i]) {
                case "+": stack.push(String.valueOf(nums1 + nums2)); break;
                case "-": stack.push(String.valueOf(nums1 - nums2)); break;
                case "*": stack.push(String.valueOf(nums1 * nums2)); break;
                case "/": stack.push(String.valueOf(nums2 / nums1)); break;
                default:
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static boolean isOpt(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
