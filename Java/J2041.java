class MovingAverage {
    int size;
    int[] arr;
    int index;
    int sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        arr = new int[size];
        index = 0;
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        sum -= arr[index % size];
        sum += val;
        arr[index % size] = val;
        index++;
        if (index < size) {
            return sum * 1.0 / index;
        } else {
            return sum * 1.0 / size;
        }
    }
}

public class J2041 {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
