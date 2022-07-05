import java.util.Map;
import java.util.TreeMap;

class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (map.isEmpty()) {
            map.put(start, end);
            return true;
        }
        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);

        if (floorEntry != null && start < floorEntry.getValue()) return false;
        if (ceilingEntry != null && end > ceilingEntry.getKey()) return false;
        map.put(start, end);
        return true;
    }
}

public class L729 {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10, 20); // return True
        myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
        myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
    }
}
