package C291;

import java.util.*;

public class C6049 {
    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{2, 3, 3, 2, 2}, 2, 2));
        System.out.println(countDistinct(new int[]{1, 2, 3, 4}, 4, 1));
        System.out.println(countDistinct(new int[]{14, 19, 9}, 1, 11));
        System.out.println(countDistinct(new int[]{16, 17, 4, 12, 3}, 4, 1));
    }

    public static int countDistinct(int[] nums, int k, int p) {
        int len = nums.length, result = 0;

        int[] suffix = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] % p == 0) suffix[i] = ++count;
            else suffix[i] = count;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String curArr = subArrV2(nums, i, j);
                if (isValid(suffix, i, j, k, p,nums[i]) && !set.contains(curArr)) {
                    result++;
                    set.add(curArr);
                }
            }
        }
        return result;
    }

    /**
     * 返回nums中从startIndex到endIndex范围的子数组字符串
     * @param nums nums数组
     * @param startIndex 子字符串开始下标，包含
     * @param endIndex 子字符串结束下标，包含
     * @return 子数组字符串
     */
    @Deprecated
    public static String subArr(int[] nums, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            sb.append(nums[i]).append('-');
        }
        return sb.toString();
    }

    /**
     * 返回nums中从startIndex到endIndex范围的子数组字符串
     * @param nums nums数组
     * @param startIndex 子字符串开始下标，包含
     * @param endIndex 子字符串结束下标，包含
     * @return 子数组字符串
     */
    public static String subArrV2(int[] nums, int startIndex, int endIndex) {
        int[] subArr = Arrays.copyOfRange(nums, startIndex, endIndex + 1);
        String subArrStr = Arrays.toString(subArr);
        return subArrStr;
    }

    /**
     * 判断子数组中可被p整除的元素是否最多只有k个
     * @param suffix 前缀数组
     * @param startIndex 开始遍历的索引
     * @param endIndex 结束遍历的索引
     * @param k k
     * @param p p
     * @param firstNum 子数组中第一个数
     * @return 数组是否符合条件
     */
    public static boolean isValid(int[] suffix, int startIndex, int endIndex, int k,int p, int firstNum) {
        int count = suffix[endIndex] - suffix[startIndex];
        if (firstNum % p ==0) count += 1;
        return count <= k;
    }
}
