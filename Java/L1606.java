import java.util.*;

public class L1606 {
    public static void main(String[] args) {
        int k = 3;
        int[] arrival = {1, 2, 3, 4, 5}, load = {5, 2, 3, 3, 3};
        List<Integer> result = busiestServers(k, arrival, load);
        System.out.println(result);

        arrival = new int[]{1, 3, 4, 5, 6, 11, 12, 13, 15, 19, 20, 21, 23, 25, 31, 32};
        load = new int[]{9, 16, 14, 1, 5, 15, 6, 10, 1, 1, 7, 5, 11, 4, 4, 6};
        result = busiestServers(7, arrival, load);
        System.out.println(result);

        arrival = new int[]{2, 3, 4, 8};
        load = new int[]{3, 2, 4, 3};
        result = busiestServers(2, arrival, load);
        System.out.println(result);

        arrival = new int[]{1, 2, 3};
        load = new int[]{10, 12, 11};
        result = busiestServers(3, arrival, load);
        System.out.println(result);

        arrival = new int[]{1};
        load = new int[]{100000};
        result = busiestServers(3, arrival, load);
        System.out.println(result);
    }

    static class Server {
        int id;
        int recentFreeTime;
        int serverCount;
    }

    public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int len = arrival.length;
        PriorityQueue<Server> busyServerQueue = new PriorityQueue<>((s1, s2) -> s1.recentFreeTime - s2.recentFreeTime);
        TreeSet<Integer> freeServerList = new TreeSet<>((s1, s2) -> s1 - s2);
        Server[] servers = new Server[k];
        List<Integer> result = new ArrayList<>();
        int maxServerCount = 0;
        for (int i = 0; i < len; i++) {
            while (i < k && i < len) {
                servers[i] = new Server();
                if (arrival[i] >= servers[i].recentFreeTime) {
                    servers[i].id = i;
                    servers[i].recentFreeTime = arrival[i] + load[i];
                    servers[i].serverCount++;
                    maxServerCount = Math.max(maxServerCount, servers[i].serverCount);
                    busyServerQueue.add(servers[i]);
                }
                i++;
            }

            if (i >= len) break;

            while (!busyServerQueue.isEmpty() && busyServerQueue.peek().recentFreeTime <= arrival[i]) {
                freeServerList.add(busyServerQueue.poll().id);
            }

            if (!freeServerList.isEmpty()) {
                Integer availableServerId = freeServerList.ceiling(i % k);
                if (availableServerId == null) {
                    availableServerId = freeServerList.first();
                    freeServerList.pollFirst();
                } else {
                    freeServerList.remove(availableServerId);
                }
                servers[availableServerId].recentFreeTime = arrival[i] + load[i];
                servers[availableServerId].serverCount++;
                maxServerCount = Math.max(maxServerCount, servers[availableServerId].serverCount);
                busyServerQueue.add(servers[availableServerId]);
            }
        }

        for (int i = 0; i < k; i++) {
            if (servers[i] != null && servers[i].serverCount == maxServerCount) {
                result.add(i);
            }
        }
        return result;
    }
}
