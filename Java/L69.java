public class L69 {
    public static void main(String[] args) {
        for (int i=0;i<36;i++){
            System.out.println("("+i+":"+mySqrt(i)+")");
        }
    }

    public static int mySqrt(int x) {
        if (x == 1) return 1;
        int left = 0, right = x;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (x / mid == mid) return mid;
            if (x / mid < mid) right = mid;
            if (x / mid > mid) left = mid;
        }
        return left;
    }
}
