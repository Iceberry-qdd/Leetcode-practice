import java.util.HashMap;
import java.util.Map;

public class L762 {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
        System.out.println(countPrimeSetBits(10, 15));
    }

    public static int countPrimeSetBits(int left, int right) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = left; i <= right; i++) {
//            int count = 0;
//            for (int j = 0; j < i && i >> j != 0; j++) {
//                if ((i >> j & 1) == 1) count++;
//            }
            int count = Integer.bitCount(i);
            map.merge(count, 1, Integer::sum);
//            System.out.println(Integer.bitCount(i));
        }

        for (Integer key : map.keySet()) {
            if (isPrime(key)) result += map.get(key);
        }
        return result;
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        int sqrtOfNum = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrtOfNum; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
