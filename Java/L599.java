import java.util.*;

public class L599 {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
        list1 = new String[]{"Shogun", "KFC", "Tapioca Express", "Burger King", "KFC"};
        list2 = new String[]{"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length, len2 = list2.length;
        int minIndexSum = Integer.MAX_VALUE;
        Map<String, Integer> indexSumMap = new HashMap<>();
        Map<String, Integer> list2Map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            list2Map.put(list2[i], i);
        }

        for (int i = 0; i < len1; i++) {
            if (list2Map.containsKey(list1[i])) {
                indexSumMap.put(list1[i], i + list2Map.get(list1[i]));
                minIndexSum = Math.min(minIndexSum, i + list2Map.get(list1[i]));
            }
        }
        indexSumMap.values().retainAll(Collections.singleton(minIndexSum));
        return indexSumMap.keySet().toArray(new String[0]);
    }
}
