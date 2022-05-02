package algorlthm.leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 7, 9, 10};
        int target = 2;

        System.out.println(new BinarySearch().binarySearch1(nums, target));
        System.out.println(new BinarySearch().binarySearch2(nums, target));
    }

    //解法1 [0,nums.length-1]
    public int binarySearch1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    // 解法2 [0,nums.length)
    public int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}


