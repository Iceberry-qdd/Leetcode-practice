import java.util.ArrayList;
import java.util.List;

public class L728 {
    public static void main(String[] args) {
        List<Integer> result = selfDividingNumbers(1, 22);
        System.out.println(result);

        result = selfDividingNumbers(47, 85);
        System.out.println(result);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static boolean isSelfDividingNumber(int num) {
        int origin_num = num;
        while (num > 0) {
            if (num % 10 == 0 || origin_num % (num % 10) != 0) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }
}
