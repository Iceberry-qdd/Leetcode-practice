import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class MyMonotonicQueue {
    private Deque<Integer> deque;

    public MyMonotonicQueue() {
        deque = new LinkedList<>();
    }

    public void pop(int val) {
        if (!deque.isEmpty() && deque.peekFirst() == val) {
            deque.pollFirst();
        }
    }

    public void add(int val) {
        while (!deque.isEmpty() && deque.peekLast() < val) {
            deque.pollLast();
        }
        deque.addLast(val);
    }

    public int max() {
        return deque.isEmpty() ? Integer.MIN_VALUE : deque.peekFirst();
    }
}

public class L239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        nums = new int[]{1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 1)));
        nums = new int[]{1, 4, 5, -3, 6, -5, 2, 1, 0, 10, -2, 5, 8};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 4)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        MyMonotonicQueue queue=new MyMonotonicQueue();

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        result[0]=queue.max();

        for (int i = k; i < len; i++) {
            queue.pop(nums[i-k]);
            queue.add(nums[i]);
            result[i-k+1]=queue.max();
        }
        return result;
    }
}
