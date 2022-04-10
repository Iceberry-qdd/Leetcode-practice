import java.util.Arrays;
import java.util.Comparator;

public class L452 {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int count = 1, len = points.length;
        for (int i = 1; i < len; i++) {
            if (points[i][0] > points[i - 1][1]) {
                //气球不挨着,需要一只箭
                count++;
            } else {
                /* 气球挨着，上一次在射爆前一个的时候，这个也被射爆了，不再需要一只箭，但是需要把这次的右
                   边界设为上气球的右边界，因为该气球已经消失了，防止该气球与后续气球有重合时被多算一次。
                 */
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
