import java.util.ArrayDeque;
import java.util.Deque;

public class L682 {
    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops));

        ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = ops.length;
        for (int i = 0; i < len; i++) {
            switch (ops[i]) {
                case "+":
                    int lastScore = stack.pop();
                    assert stack.peek() != null;
                    int lastLastScore = stack.peek();
                    stack.push(lastScore);
                    stack.push(lastLastScore + lastScore);
                    break;
                case "D":
                    assert stack.peek() != null;
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(ops[i]));
            }
        }

        int result = stack.stream().mapToInt(Integer::intValue).sum();
        return result;
    }
}
