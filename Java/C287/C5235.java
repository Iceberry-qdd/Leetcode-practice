package C287;

import java.util.*;

public class C5235 {
    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        List<List<Integer>> result = findWinners(matches);
        System.out.println(result);
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        int len = matches.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> answer0 = new ArrayList<>();
        List<Integer> answer1 = new ArrayList<>();

        Map<Integer, Integer> loseCount = new HashMap<>();
        Set<Integer> person = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            loseCount.merge(matches[i][1], 1, Integer::sum);
            person.add(matches[i][0]);
            person.add(matches[i][1]);
        }

        for (Integer index : person) {
            if (loseCount.containsKey(index) && loseCount.get(index) == 1) {
                answer1.add(index);
            }
            if (!loseCount.containsKey(index)) answer0.add(index);
        }

        result.add(answer0);
        result.add(answer1);
        return result;
    }
}
