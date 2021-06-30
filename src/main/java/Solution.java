class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]+nums[j]==9){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr =[3,2,4]
//        new Solution().twoSum()
    }
}