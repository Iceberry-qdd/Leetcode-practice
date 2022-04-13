import java.io.Serializable;
import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int len = list.size();
        Integer index = map.get(val);
        Integer lastElem = list.get(len - 1);
        list.set(index, lastElem);
        map.put(lastElem, index);
        list.remove(len - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int len = list.size();
        int randomIndex = random.nextInt(len);
        return list.get(randomIndex);
    }
}

public class L380 {
    public static void main(String[] args) {

        RandomizedSet randomizedSet = new RandomizedSet();
        List<? extends Serializable> list = List.of(randomizedSet.insert(1),
                randomizedSet.insert(1),
                randomizedSet.remove(2),
                randomizedSet.insert(2),
                randomizedSet.getRandom(),
                randomizedSet.remove(1),
                randomizedSet.insert(2),
                randomizedSet.getRandom());
        System.out.println(list);

        randomizedSet=new RandomizedSet();
        list = List.of(randomizedSet.insert(0),
                randomizedSet.insert(1),
                randomizedSet.remove(0),
                randomizedSet.insert(2),
                randomizedSet.remove(1),
                randomizedSet.getRandom());
        System.out.println(list);
    }
}
