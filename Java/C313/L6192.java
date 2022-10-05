package C313;

public class L6192 {
    public static void main(String[] args) {

    }

    public static int commonFactors(int a, int b) {
        if (a < b) return commonFactors(b, a);

        int result = 0;
        for (int i = 1; i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                result++;
            }
        }
        return result;
    }
}
