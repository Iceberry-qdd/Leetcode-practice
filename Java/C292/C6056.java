package C292;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C6056 {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
    }

    public static String largestGoodInteger(String num) {
        int count = 1, len = num.length(), left = 0;
        List<String> list = new ArrayList<>();
        for (int right = 1; right < len; right++) {
            if (num.charAt(left) == num.charAt(right)) {
                count++;
            } else {
                left = right;
                count = 1;
            }
            if (count == 3) {
                list.add(String.format("%c%c%c", num.charAt(left), num.charAt(left), num.charAt(left)));
            }
        }
        list.sort(Comparator.naturalOrder());

        return list.size() == 0 ? "" : list.get(list.size() - 1);
    }
}
