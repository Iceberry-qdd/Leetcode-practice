import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L735 {
    public static void main(String[] args) {
        int[] result = asteroidCollision(new int[]{5, 10, -5});
        System.out.println(Arrays.toString(result));

        result = asteroidCollision(new int[]{8, -8});
        System.out.println(Arrays.toString(result));

        result = asteroidCollision(new int[]{10, 2, -5});
        System.out.println(Arrays.toString(result));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            //遇到向右转的行星或者栈为空，则直接将当前元素入栈
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }
            boolean flag = true; //当前行星是否应添加到栈中
            while (!stack.isEmpty()) {
                Integer topElem = stack.peek(); //取栈顶元素

                if (topElem < 0) { //栈顶行星向左转，添加当前行星，结束
                    break;
                } else if (topElem == -asteroids[i]) { //该行星与栈顶行星一样大，栈顶元素出栈，结束
                    stack.pop();
                    flag = false;
                    break;
                } else if (topElem > -asteroids[i]) { //该行星比栈顶行星小，结束
                    flag = false;
                    break;
                } else { //该行星比栈顶元素大，栈顶元素出栈
                    stack.pop();
                }
            }
            if (flag) stack.push(asteroids[i]);
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
