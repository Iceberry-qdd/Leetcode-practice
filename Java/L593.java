import java.util.Arrays;

public class L593 {
    public static void main(String[] args) {
        System.out.println(validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] len = new int[6];
        len[0] = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        len[1] = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        len[2] = (p1[0] - p4[0]) * (p1[0] - p4[0]) + (p1[1] - p4[1]) * (p1[1] - p4[1]);
        len[3] = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        len[4] = (p2[0] - p4[0]) * (p2[0] - p4[0]) + (p2[1] - p4[1]) * (p2[1] - p4[1]);
        len[5] = (p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1]);

        Arrays.sort(len);

        if (len[0] == 0 || len[4] != len[5]) return false;

        int a = len[0], l = len[5];
        return a * 2 == l;
    }
}
