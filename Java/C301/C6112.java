package C301;

import java.util.Arrays;

public class C6112 {
    public static void main(String[] args) {

    }

    public static int fillCups(int[] amount) {
        Arrays.sort(amount);
        int len = amount.length, sum = 0, result = 0;
        for (int i = 0; i < len; i++) {
            sum += amount[i];
        }

        if (amount[0] + amount[1] < amount[2]) result = amount[2];
        else result = (sum + 1) / 2;
        return result;

    }
}
