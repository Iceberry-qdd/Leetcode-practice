import java.util.Arrays;
import java.util.LinkedList;

public class L406 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = reconstructQueue(people);
        System.out.println(Arrays.deepToString(result));

    }

    public static int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) return p1[1] - p2[1];
            else return p2[0] - p1[0];
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            list.add(people[i][1], people[i]);
        }

        return list.toArray(new int[][]{});
    }
}
