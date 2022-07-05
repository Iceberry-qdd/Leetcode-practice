public class L1175 {
    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(5));
        System.out.println(numPrimeArrangements(100));
        System.out.println(numPrimeArrangements(1));
    }

    private static final int MOD = 1000000007;

    public static int numPrimeArrangements(int n) {
        int primeCount = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) primeCount++;
        }

        return (int) ((factorial(primeCount) * factorial(n - primeCount)) % MOD);
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static long factorial(int num) {
        if (num == 1 || num==0) return 1;
        else return num * factorial(num - 1) % MOD;
    }
}
