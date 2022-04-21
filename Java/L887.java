public class L887 {
    public static void main(String[] args) {
        System.out.println(superEggDrop(1, 2));
        System.out.println(superEggDrop(2, 6));
        System.out.println(superEggDrop(3, 14));
    }

    public static int superEggDrop(int k, int n) {
        int t = 1;
        while (findF(k, t) < n + 1) t++;
        return t;
    }

    public static int findF(int k, int t) {
        if (k == 1 || t == 1) return t + 1;
        return findF(k - 1, t - 1) + findF(k, t - 1);
    }
}
