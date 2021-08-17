package algorlthm.leetcode.twopoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Merge {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int indexM = m - 1;
        int indexN = n - 1;
        int i = m + n - 1;

        while (i>=0){
            if (indexM < 0) {  // 直接另一个数组取元素 给大数组
                nums1[i--] = nums2[indexN--];
            }else if (indexN<0){
                nums1[i--] = nums1[indexM--]; // 同上
            }else if(nums1[indexM] > nums2[indexN]){//取大的元素数组
                nums1[i--] = nums1[indexM--]; // --先赋值再 减1
            } else {
                nums1[i--] = nums2[indexN--];
            }
        }
        return nums1;
    }


    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    @Test
    void test() {
        Merge merge = new Merge();
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, merge.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3));
        assertArrayEquals(new int[]{1}, merge.merge(new int[]{1}, 1, new int[]{}, 0));
        assertArrayEquals(new int[]{1}, merge.merge(new int[]{0}, 0, new int[]{1}, 1));

    }
}
