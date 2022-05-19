package C293;

public class C6065 {
    public static void main(String[] args) {
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        System.out.println(largestCombination(candidates));
        candidates = new int[]{8, 8};
        System.out.println(largestCombination(candidates));
    }

    public static int largestCombination(int[] candidates) {
        int len = candidates.length, result = 0;
        int[] bitArr = new int[24];
        for (int i = 0; i < len; i++) {
            int j = 0;
            while ((candidates[i] >> j) != 0) {
                if (((candidates[i] >> j) & 1) == 1) {
                    bitArr[j]++;
                }
                j++;
            }
        }

        for (int i = 0; i < bitArr.length; i++) {
            result = Math.max(result, bitArr[i]);
        }
        return result;
    }
}
