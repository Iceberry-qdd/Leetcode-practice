public class L367 {

    public static void main(String[] args) {
        int x=1000000;
        System.out.println("("+x+":"+isPerfectSquare(x)+")");
        System.out.println(250000*250000);
//        for (int i=0;i<36;i++){
//            System.out.println("("+i+":"+mySqrt(i)+")");
//        }
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 1, right = num;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (num*1.0 / mid == mid) return true;
            if (num*1.0 / mid < mid) right = mid;
            if (num*1.0 / mid > mid) left = mid;
        }
        return false;
    }
}
