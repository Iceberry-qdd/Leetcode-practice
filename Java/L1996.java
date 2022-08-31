import java.util.Arrays;

public class L1996 {
    public static void main(String[] args) {
        System.out.println(numberOfWeakCharacters(new int[][]{{5, 5}, {6, 3}, {3, 6}}));
        System.out.println(numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}}));
        System.out.println(numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}}));
        System.out.println(numberOfWeakCharacters(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}));
    }

    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (p1, p2) -> {
            if (p1[0] == p2[0]) return p1[1] - p2[1];
            else return p2[0] - p1[0];
        });

        int result = 0, len = properties.length, maxDefense = -1;
        for (int i = 0; i < len; i++) {
            if (properties[i][1] < maxDefense) {
                result++;
            }
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        return result;
    }
}
