package leetcode.arr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//https://leetcode-cn.com/problems/valid-palindrome-ii/description/
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (charArr[lo] == charArr[hi]) {
                lo++;
                hi--;
            }else {
                return  isPalindrome(charArr,lo+1,hi)||isPalindrome(charArr,lo,hi-1);
            }

        }
        return true;
    }

    private boolean isPalindrome(char[] charArr, int lo, int hi) {
        while (lo < hi) {
            if (charArr[lo] == charArr[hi]) {
                lo++;
                hi--;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * 如果charArr[lo] != charArr[hi],这种方式先跳过lo,能成功，但是后面就匹配不了，其实跳过hi也能匹配成功，并且后面还能继续匹配。
     */
//    public boolean validPalindrome(String s) {
//        char[] charArr = s.toCharArray();
//        int lo = 0;
//        int hi = s.length() - 1;
//        boolean chance = true;
//        while (lo <= hi) {
//            if (charArr[lo] == charArr[hi]) {
//                lo++;
//                hi--;
//            } else {
//                if (chance){
//                    chance = false;
//                    if (charArr[lo + 1] == charArr[hi]) {
//                        lo++;
//                    } else if (charArr[lo] == charArr[hi - 1]) {
//                        hi--;
//                    }else {
//                        return false;
//                    }
//                }else {
//                    return false;
//                }
//            }
//            if(lo>=hi){
//                return true;
//            }
//        }
//        return false;
//    }

    @Test
    void test(){
        ValidPalindrome vpd = new ValidPalindrome();
        assertEquals(true,vpd.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        assertEquals(false,vpd.validPalindrome("eeccccbebaeeabebccceea"));
        assertEquals(true,vpd.validPalindrome("bddb"));
        assertEquals(false,vpd.validPalindrome("atbbga"));
        assertEquals(false,vpd.validPalindrome("abc"));
        assertEquals(true,vpd.validPalindrome("aba"));
        assertEquals(true,vpd.validPalindrome("abca"));
    }
}
