public class L258 {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.printf("%d--%d\n", i, addDigits(i));
            System.out.printf("%d--%d\n\n", i, addDigitsV2(i));
        }
    }

    public static int addDigits(int num) {
        while (true) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }
            if (sum < 10) return sum;
            else num = sum;
        }
    }

    public static int addDigitsV2(int num) {
        //return num==0?0:num%9;
        if (num == 0) return 0;
        else if (num % 9 == 0) return 9;
        else return num % 9;
    }
}
