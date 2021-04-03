package datastruct.lagou;

public class Gongjin07Exercise {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        for (int i = 0; i < nums.length - 1; i++) {
            int replaceIndex = -1;
            for (int j = 0; i < nums.length - 1; j++) {
                if (nums[i] == nums[j]) {
                    replaceIndex = i + 1;
                }
                if (replaceIndex != -1) {
                    for (int k = replaceIndex; k < nums.length - 1; k++) {
                        nums[k] = nums[k + 1];
                    }
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }


    }


}

