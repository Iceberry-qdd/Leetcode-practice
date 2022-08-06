import java.util.Arrays;

class MyCircularQueue {
    int[] arr;
    int front, tail;

    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
        front = -1;
        tail = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            arr[tail % arr.length] = value;
            tail++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            front++;
            return true;
        }
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[front % arr.length];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[(tail - 1) % arr.length];
        }
    }

    public boolean isEmpty() {
        return tail == front;
    }

    public boolean isFull() {
        return tail - front == arr.length;
    }
}

public class L622 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1); // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear(); // 返回 3
        circularQueue.isFull(); // 返回 true
        circularQueue.deQueue(); // 返回 true
        circularQueue.enQueue(4); // 返回 true
        circularQueue.Rear(); // 返回 4
    }
}
