import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size = queue.size();
        while (size-- > 1) {
            queue.add(queue.remove());
        }
        return queue.remove();
    }

    public int top() {
        int top = this.pop();
        queue.add(top);
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

public class L225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }
}
