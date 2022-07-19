package C302;

import java.math.BigInteger;
import java.util.*;

public class C6122 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 3, 2, 4, 3}, new int[]{9, 6, 9, 3, 15}));
        System.out.println(minOperations(new int[]{3, 2, 6, 2, 35, 5, 35, 2, 5, 8, 7, 3, 4}, new int[]{105, 70, 70, 175, 105, 105, 105}));
    }

    public static int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        BigInteger g = BigInteger.valueOf(numsDivide[0]);
        for (int i = 1; i < numsDivide.length; i++) {
            BigInteger num = BigInteger.valueOf(numsDivide[i]);
            g = num.gcd(g);
        }

        int maxConvention = g.intValue();
        for (int i = 0; i < nums.length; i++) {
            if (maxConvention % nums[i] == 0) return i;
        }
        return -1;
    }

}
