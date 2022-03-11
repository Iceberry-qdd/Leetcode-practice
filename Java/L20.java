import java.util.ArrayDeque;
import java.util.Deque;

public class L20 {
    public static void main(String[] args) {
        String s = "(){}[]";
        System.out.println(isValid(s));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("["));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        int len = s.length();
        if (len == 1) return false;
        Deque<Character> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            if (isLeft(s.charAt(i))) {
                stack.push(s.charAt(i));
                continue;
            }

            if (!stack.isEmpty() && isPair(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else return false;
        }
        return stack.isEmpty();
    }

    public static boolean isLeft(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static boolean isPair(char a, char b) {
        return a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}';
    }
}
