package algorlthm.leetcode;

public class Javatest {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 2, 3, 4};
        new Javatest().removeElement(nums, 3);
        System.out.println(nums);
    }
}