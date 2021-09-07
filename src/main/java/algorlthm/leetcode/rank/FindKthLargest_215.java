package algorlthm.leetcode.rank;

import org.junit.Test;
import util.Print;

import static org.junit.Assert.assertEquals;

public class FindKthLargest_215 {
    public int findKthLargest(int[] nums, int k) {

        quickSort(nums, 0, nums.length - 1);

        return nums[nums.length-k];
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mi = partition(nums, lo, hi);
        quickSort(nums, lo, mi - 1);
        quickSort(nums, mi + 1, hi);

    }


    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo<hi&&nums[hi] >= pivot) {
                hi--;
            }
            nums[lo] = nums[hi];
            while (lo<hi&&nums[lo] <= pivot) {
                lo++;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }

    public static void main(String[] args) {
        FindKthLargest_215 fkl = new FindKthLargest_215();
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        fkl.quickSort(arr, 0, arr.length - 1);
        Print.printArr(arr);
    }


    @Test
    void test(){
        FindKthLargest_215 fkl = new FindKthLargest_215();
        assertEquals(5,fkl.findKthLargest(new int[]{3, 2, 1, 5, 6, 4},2));
        assertEquals(4,fkl.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
