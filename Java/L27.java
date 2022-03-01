public class L27 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length, fastIndex = 0, slowIndex = 0;
        while (fastIndex < length) {
            if (nums[fastIndex] == val) {
                fastIndex++;
                continue;
            }
            nums[slowIndex++] = nums[fastIndex++];
        }

//        for (fastIndex=0;fastIndex<length;fastIndex++){
//            if (nums[fastIndex]!=val){
//                nums[slowIndex++] = nums[fastIndex];
//            }
//        }
        return slowIndex;
    }
}
