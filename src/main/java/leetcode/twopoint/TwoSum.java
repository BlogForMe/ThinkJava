package leetcode.twopoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSum {

    //这种方法不知道为啥 leetCode编译报错
//    public int[] towSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length; i++) {
//            int lo = 0;
//            int hi = numbers.length - 1;
//            for (int j = 0; j < numbers.length; j++) {
//                if (i != lo && (numbers[i] + numbers[lo] == target)) {
//                    return new int[]{i + 1, lo + 1};
//                } else if (hi > 0) {
//                    hi--;
//                }
//                if (i != hi && (numbers[i] + numbers[hi] == target)) {
//                    return new int[]{i + 1, hi + 1};
//                } else if (lo < numbers.length) {
//                    lo++;
//                }
//            }
//        }
//        return new int[]{};
//    }


    public int[] towSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length-1;
        while (lo<hi){
            if (numbers[lo]+numbers[hi]>target){
                hi--;
            }else if (numbers[lo]+numbers[hi]<target){
                lo++;
            }else {
                return new int[]{lo+1,hi+1};
            }
        }
        return new int[]{};
    }

    public int[] testArr(){
        return new int[]{1,2};
    }
   /*
    public int[] towSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int tarNum = target - numbers[i];
//           int tarIndex=findNum(numbers,0,numbers.length-1,tarNum);
//            int tarIndex = findNum(numbers, tarNum, i);
            int lo = 0;
            int hi = numbers.length;
            for (int j = 0; j < numbers.length; j++) {
                int mi = (lo + hi) >> 1;
                if (lo < hi) {
                    if (tarNum > numbers[mi]) {
                        lo = mi + 1;
                    } else if (tarNum < numbers[mi]) {
                        hi = mi-1;
                    } else {
                        if (i == mi) {
                            continue;
                        } else {
                            return new int[]{i + 1, mi + 1};
                        }
                    }
                }
            }
        }
        return new int[]{};
    }*/

    private int findNum(int[] numbers, int tarNum, int i) {
        int lo = 0;
        int hi = numbers.length;
        for (int j = 0; j < numbers.length; j++) {
            int mi = (lo + hi) >> 1;
            if (tarNum > numbers[mi]) {
                lo = mi + 1;
            } else if (tarNum < numbers[mi]) {
                hi = mi;
            } else {
                if (i == mi) {
                    continue;
                } else
                    return mi;
            }
        }
        return 0;
    }

    private int findNum(int[] numbers, int lo, int hi, int tarNum) {
        int mi = (lo + hi) >> 1;
        if (tarNum > numbers[mi]) {
            lo = mi + 1;
        } else if (tarNum < numbers[mi]) {
            hi = mi - 1;
        } else {
            return mi;
        }
        return findNum(numbers, lo, hi, tarNum);
    }

    @Test
    void test() {

//        int[] arr = {1, 3, 4, 4};
//        int[] arr = {0, 0, 3, 4};
//        int[] arr = {5, 25, 75};
//        int[] arr = {2,3,4};

//        int[] solutions = new TwoSum().towSum(arr, 8);
//        Print.printArr(solutions);
        final TwoSum twoSum = new TwoSum();

        assertArrayEquals(new int[]{1,2},twoSum.towSum(new int[]{2, 7, 11, 15},9));
        assertArrayEquals(new int[]{1,2},twoSum.towSum(new int[]{0, 0, 3, 4},0));
        assertArrayEquals(new int[]{2,3},twoSum.towSum(new int[]{5, 25, 75},100));
        assertArrayEquals(new int[]{2,3},twoSum.towSum(new int[]{2,3,4},7));
//        assertArrayEquals(expect,twoSum.testArr());


    }

}
