import java.util.Arrays;

public class L455 {
    public static void main(String[] args) {
        int[] g = {1, 2, 3}, s = {1, 1};
        int result = findContentChildren(g, s);
        System.out.println(result);
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int lenG = g.length, lenS = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < lenS && j < lenG; i++) {
            if (s[i] < g[j]) continue;
            count++;
            j++;
        }
        return count;
    }
}
