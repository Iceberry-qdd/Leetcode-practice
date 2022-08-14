import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class L636 {
    public static void main(String[] args) {

    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int len = logs.size(), curTime = -1;
        int[] result = new int[n];
        Deque<Integer> queue = new ArrayDeque<>();
        for (String log : logs) {
            String[] str = log.split(":");
            int funId = Integer.parseInt(str[0]);
            int timestamp = Integer.parseInt(str[2]);
            String flag = str[1];
            if (flag.equals("start")) {
                if (!queue.isEmpty()) {
                    result[queue.peekLast()] += timestamp - curTime;
                }
                queue.addLast(funId);
                curTime = timestamp;
            } else {
                funId = queue.pollLast();
                result[funId] += timestamp - curTime + 1;
                curTime = timestamp + 1;
            }
        }
        return result;
    }
}
