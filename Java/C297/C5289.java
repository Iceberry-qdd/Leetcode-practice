package C297;

public class C5289 {
    public static void main(String[] args) {
        System.out.println(distributeCookies(new int[]{8, 15, 10, 20, 8}, 2));
    }

    static int result = Integer.MAX_VALUE;
    static int[] kids;

    public static int distributeCookies(int[] cookies, int k) {
        kids = new int[k];
        backTracing(cookies, 0, k);
        return result;
    }

    public static void backTracing(int[] cookies, int startIndex, int k) {
        int len = cookies.length;
        if (startIndex == len) {
            int max = 0;
            for (int kid : kids) {
                max = Math.max(max, kid);
            }
            result = Math.min(result, max);
            return;
        }

        for (int i = 0; i < k; i++) {
            kids[i] += cookies[startIndex];
            backTracing(cookies, startIndex + 1, k);
            kids[i] -= cookies[startIndex];
        }
    }
}
