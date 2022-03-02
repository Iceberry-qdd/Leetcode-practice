import java.util.ArrayList;
import java.util.List;

public class L54 {
    public static void main(String[] args) {
        //int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}));
        System.out.println(spiralOrder(new int[][]{{0}, {1}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int lenColumn = matrix[0].length, lenRow = matrix.length;
        List<Integer> result = new ArrayList<>(lenColumn * lenRow);
        int top = 0, right = 0, bottom = 0, left = 0;
        int laps = 0, count = lenColumn * lenRow;
        while (count > 0) {
            while (top < lenColumn - 1 - laps && count > 0) {
                result.add(matrix[laps][top]);
                top++;
                count--;
            }

            while (right < lenRow - 1 - laps && count > 0) {
                result.add(matrix[right][lenColumn - 1 - laps]);
                right++;
                count--;
            }

            while (bottom < lenColumn - 1 - laps && count > 0) {
                result.add(matrix[lenRow - 1 - laps][lenColumn - 1 - bottom]);
                bottom++;
                count--;
            }

            while (left < lenRow - 1 - laps && count > 0) {
                result.add(matrix[lenRow - 1 - left][laps]);
                left++;
                count--;
            }

            if (lenRow == lenColumn && (lenColumn * lenRow) % 2 != 0 && result.size() == lenColumn * lenRow - 1) {
                result.add(matrix[lenRow >> 1][lenColumn >> 1]);
                break;
            }

            top = bottom = left = right = ++laps;
        }
        return result;
    }
}
