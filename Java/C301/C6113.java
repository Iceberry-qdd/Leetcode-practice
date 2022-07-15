package C301;

import java.util.*;

class SmallestInfiniteSet {
    Set<Integer> excludeSet;

    public SmallestInfiniteSet() {
        excludeSet = new HashSet<>();
    }

    public int popSmallest() {
        int startElem = 1;
        while (true) {
            if (excludeSet.contains(startElem)) {
                startElem++;
            } else {
                excludeSet.add(startElem);
                return startElem;
            }
        }
    }

    public void addBack(int num) {
        excludeSet.remove(num);
    }
}

public class C6113 {
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
        smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
        smallestInfiniteSet.popSmallest(); // 返回 2 ，并将其从集合中移除。
        smallestInfiniteSet.popSmallest(); // 返回 3 ，并将其从集合中移除。
        smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
        smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 在上一步中被添加到集合中，
        // 且 1 是最小的整数，并将其从集合中移除。
        smallestInfiniteSet.popSmallest(); // 返回 4 ，并将其从集合中移除。
        smallestInfiniteSet.popSmallest(); // 返回 5 ，并将其从集合中移除。
    }
}
