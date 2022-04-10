package C288;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C6037 {
    public static void main(String[] args) {
        System.out.println(largestInteger(1234));
        System.out.println(largestInteger(65875));
        System.out.println(largestInteger(247));
        System.out.println(largestInteger(9));
    }

    public static int largestInteger(int num) {
        int num_backup = num;
        List<Integer> list = new ArrayList<>();
        while (num_backup != 0) {
            list.add(num_backup % 10);
            num_backup /= 10;
        }

        int len = list.size();
        List<Integer> list1 = new ArrayList<>();// 奇数
        List<Integer> list2 = new ArrayList<>();// 偶数
        List<Integer> index = new ArrayList<>();// 每个index在哪个list中
        for (int i = len - 1; i >= 0; i--) {
            int temp = list.get(i);
            if (temp % 2 == 0) {
                list2.add(temp);
                index.add(2);
            } else {
                list1.add(temp);
                index.add(1);
            }
        }

        list1.sort(Comparator.reverseOrder());
        list2.sort(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder(len);
        int list1Index = 0, list2Index = 0;
        for (int i = 0; i < len; i++) {
            if (index.get(i) == 1) {
                sb.append(list1.get(list1Index++));
            } else {
                sb.append(list2.get(list2Index++));
            }
        }
        return Integer.parseInt(sb.toString());
    }

}
