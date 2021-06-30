package leetcode.twopoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int lo = 0;
        int hi = (int) Math.sqrt(c);
        while (lo<=hi){
            if (lo*lo+hi*hi>c){
                hi--;
            }else if (lo*lo+hi*hi<c){
                lo++;
            }else {
                System.out.println(" lo "+ lo + " hi " + hi);
                return true;
            }
        }
        return false;
    }

    @Test
    void test(){
        JudgeSquareSum judgeSum = new JudgeSquareSum();

        assertEquals(true,judgeSum.judgeSquareSum(5));
        assertEquals(false,judgeSum.judgeSquareSum(3));
        assertEquals(true,judgeSum.judgeSquareSum(4));
        assertEquals(true,judgeSum.judgeSquareSum(2));
        assertEquals(true,judgeSum.judgeSquareSum(1));
    }
}
