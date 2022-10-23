import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    Deque<int[]> queue;
    int curIndex;

    public StockSpanner() {
        queue = new ArrayDeque<>();
        curIndex = 0;
    }

    public int next(int price) {
        while (!queue.isEmpty() && queue.peekLast()[1] <= price) {
            queue.pollLast();
        }

        int result = curIndex - (queue.isEmpty() ? -1 : queue.peekLast()[0]);
        queue.addLast(new int[]{curIndex++, price});
        return result;
    }
}

public class L901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner=new StockSpanner();
        int result = stockSpanner.next(100);
        System.out.println(result);
        result=stockSpanner.next(80);
        System.out.println(result);
        result=stockSpanner.next(60);
        System.out.println(result);
        result=stockSpanner.next(70);
        System.out.println(result);
        result=stockSpanner.next(60);
        System.out.println(result);
        result=stockSpanner.next(75);
        System.out.println(result);
        result=stockSpanner.next(85);
        System.out.println(result);
    }
}
