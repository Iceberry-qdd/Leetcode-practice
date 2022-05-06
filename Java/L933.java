import java.util.ArrayDeque;
import java.util.Deque;

class RecentCounter {
    Deque<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.addLast(t);
        while (queue.peek() != null) {
            if (queue.peek() > t || queue.peek() < t - 3000) {
                queue.removeFirst();
            } else return queue.size();
        }

        return queue.size();
    }
}

public class L933 {
    public static void main(String[] args) {

    }
}
