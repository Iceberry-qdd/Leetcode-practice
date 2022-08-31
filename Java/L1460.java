import java.util.Arrays;

public class L1460 {
    public static void main(String[] args) {

    }

    public boolean canBeEqual(int[] target, int[] arr) {
        int len = target.length;
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
