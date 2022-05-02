package algorlthm.leetcode.array;

public class Solution35 {
    public static void main(String[] args) {
        System.out.println(new Solution35().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new Solution35().searchInsert(new int[]{1,3,5,6}, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
