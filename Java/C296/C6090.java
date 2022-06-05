package C296;

public class C6090 {
    public static void main(String[] args) {

    }

    public int minMaxGame(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        int[] newNums = new int[len / 2];
        for (int i = 0; i < len / 2; i++) {
            if (i % 2 == 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newNums);
    }
}
