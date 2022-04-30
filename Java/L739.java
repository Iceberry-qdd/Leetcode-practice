import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L739 {
    public static void main(String[] args) {
        int[] result = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(result));

        result = dailyTemperatures(new int[]{30, 40, 50, 60});
        System.out.println(Arrays.toString(result));

        result = dailyTemperatures(new int[]{30, 60, 90});
        System.out.println(Arrays.toString(result));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[len];

        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getFirst()]) {
                result[stack.getFirst()] = i - stack.getFirst();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
