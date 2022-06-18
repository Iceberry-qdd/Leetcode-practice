import java.util.Arrays;

public class L1089 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{1, 2, 3};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 0, 0, 0, 0, 0, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 1, 7, 6, 0, 2, 0, 7};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{8, 4, 5, 0, 0, 0, 0, 7};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0, 2, 3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0, 8, 8, 8, 8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{1, 5, 2, 0, 6, 8, 0, 6, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void duplicateZeros(int[] arr) {
        int len = arr.length, slow = 0, fast = 0;
        while (fast < len) {
            if (arr[slow] == 0) fast += 2;
            else fast += 1;
            slow++;
        }

        int index = slow - 1;
        for (int i = len - 1; i > 0; i--) {
            if (arr[index] != 0) arr[i] = arr[index];
            else if (index == slow - 1 && fast > len) arr[i] = arr[index];
            else {
                arr[i] = arr[index];
                arr[--i] = 0;
            }
            index--;
        }
    }
}
