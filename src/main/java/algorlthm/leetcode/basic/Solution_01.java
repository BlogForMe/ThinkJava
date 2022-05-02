package algorlthm.leetcode.basic;

/**
 * 使用两个指针，右指针始终往右移动，
 * <p>
 * 如果右指针指向的值等于左指针指向的值，左指针不动。
 * 如果右指针指向的值不等于左指针指向的值，那么左指针往右移一步，然后再把右指针指向的值赋给左指针。
 * <p>
 * 作者：数据结构和算法
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/?discussion=4Zkrel
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution_01 {
    public int removeDuplicates(int[] nums) {
        //边界条件判断
        if (nums == null || nums.length == 0)
            return 0;
        int p1 = 0;
        int p2 = 1;

        while (p2 < nums.length) {
            if (nums[p1] == nums[p2]) {
                p2++;            //左指针不动,右指针移动
            } else {
                p1++;           //左指针往右移一步
                if (p1 != p2) { //不在同一个位置
                    nums[p1] = nums[p2]; //然后再把右指针指向的值赋给左指针
                }
            }
        }
        return ++p1;
    }


    public static void main(String[] args) {

    }
}
