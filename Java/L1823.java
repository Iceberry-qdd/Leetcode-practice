import java.util.ArrayDeque;
import java.util.Deque;

public class L1823 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
    }

    public static int findTheWinner(int n, int k) {
        if (n == 1) return 1;

        Deque<Integer> queue = new ArrayDeque<>(n);
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }

        while (queue.size() > 1) {
            int _k = k - 1;
            while (_k > 0) {
                Integer num = queue.removeFirst();
                queue.addLast(num);
                _k--;
            }
            queue.removeFirst();
        }
        return queue.getFirst();
    }
}
