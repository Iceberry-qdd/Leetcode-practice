public class L26 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4,4,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length, fastIndex = 0, slowIndex = 0;
//        while (fastIndex<length-1){
//            if (nums[fastIndex]==nums[fastIndex+1]){
//                fastIndex++;
//                continue;
//            }
//            nums[slowIndex++]=nums[fastIndex++];
//        }


        for (fastIndex = 0; fastIndex < length-1; fastIndex++)
            if (nums[fastIndex] != nums[fastIndex + 1]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        nums[slowIndex++] = nums[length - 1];
        return slowIndex;
    }
}
