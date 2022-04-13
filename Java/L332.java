import java.util.*;

public class L332 {
    public static void main(String[] args) {
        List<List<String>> tickets = List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"), List.of("SFO", "SJC"), List.of("LHR", "SFO"));
        List<String> result = findItinerary(tickets);
        System.out.println(result);

        tickets = List.of(List.of("JFK", "SFO"), List.of("JFK", "ATL"), List.of("SFO", "ATL"), List.of("ATL", "JFK"), List.of("ATL", "SFO"));
        result = findItinerary(tickets);
        System.out.println(result);

        tickets = List.of(List.of("JFK", "KUL"), List.of("JFK", "NRT"), List.of("NRT", "JFK"));
        result = findItinerary(tickets);
        System.out.println(result);
    }


    static HashMap<String, TreeMap<String, Integer>> map = new HashMap<>();

    public static List<String> findItinerary(List<List<String>> tickets) {
        initMap(tickets);
        List<String> result = new ArrayList<>();
        result.add("JFK");

        backTracing(tickets.size(), result);
        return result;
    }

    public static void initMap(List<List<String>> tickets) {
        map.clear();
        for (List<String> ticket : tickets) {
            String curBeginCity = ticket.get(0);
            String curArriveCity = ticket.get(1);
            if (map.containsKey(curBeginCity)) {
                TreeMap<String, Integer> treeMap = map.get(curBeginCity);
                treeMap.merge(curArriveCity, 1, Integer::sum);
            } else {
                TreeMap<String, Integer> treeMap = new TreeMap<>();
                treeMap.put(curArriveCity, 1);
                map.put(curBeginCity, treeMap);
            }
        }
    }

    public static boolean backTracing(int ticketsCount, List<String> result) {
        int len = result.size();
        if (len == ticketsCount + 1) return true;

        TreeMap<String, Integer> ticketArriveCiTyCount = map.get(result.get(len - 1));
        if (ticketArriveCiTyCount == null) return false;
        for (Map.Entry<String, Integer> tacc : ticketArriveCiTyCount.entrySet()) {
            if (tacc.getValue() > 0) {
                result.add(tacc.getKey());
                ticketArriveCiTyCount.merge(tacc.getKey(), -1, Integer::sum);
                if (backTracing(ticketsCount, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
                ticketArriveCiTyCount.merge(tacc.getKey(), 1, Integer::sum);
            }
        }
        return false;
    }
}
