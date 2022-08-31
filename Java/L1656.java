import java.util.ArrayList;
import java.util.List;

class OrderedStream {
    String[] values;
    int ptr;
    int n;

    public OrderedStream(int n) {
        this.values = new String[n + 2];
        this.ptr = 1;
        this.n = n;
    }

    public List<String> insert(int idKey, String value) {
        values[idKey] = value;
        List<String> result = new ArrayList<>();
        if (values[ptr] == null) return result;
        while (ptr < n + 1 && values[ptr] != null) {
            result.add(values[ptr]);
            ptr++;
        }
        return result;
    }
}

public class L1656 {
    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
        os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
        os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]

    }
}
