import java.util.ArrayList;
import java.util.List;

public class L658 {
    public static void main(String[] args) {
        List<Integer> result = findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        System.out.println(result);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;

        int left = 0, right = len - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) left = mid + 1;
            else right = mid;
        }

        List<Integer> list = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

}
