import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1282 {
    public static void main(String[] args) {
        List<List<Integer>> result = groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        System.out.println(result);
        result = groupThePeople(new int[]{2, 1, 3, 3, 3, 2});
        System.out.println(result);
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(groupSizes[i])) {
                List<Integer> list = map.get(groupSizes[i]);
                list.add(i);
                map.put(groupSizes[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<Integer> item = new ArrayList<>();
            List<Integer> list = map.get(key);
            for (int i = 0; i < list.size(); i++) {
                item.add(list.get(i));
                if (item.size() == key) {
                    result.add(item);
                    item = new ArrayList<>();
                }
            }
        }
        return result;
    }
}
