package algorlthm.leetcode.twopoint;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseVowels {
    public String reverseVowels(String s) {
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int lo = 0;
        int hi = s.length() - 1;
        char[] resultArr = new char[s.length()];
        while (lo <= hi) {
            if (!list.contains(s.charAt(lo))) {
                resultArr[lo] = s.charAt(lo);
                lo++;
            }else if (!list.contains(s.charAt(hi))){
                resultArr[hi] = s.charAt(hi);
                hi--;
            }else {
                resultArr[lo] = s.charAt(hi);
                resultArr[hi] = s.charAt(lo);
                lo++;
                hi--;
            }
        }
        return new String(resultArr);
    }
//private final static HashSet<Character> vowels = new HashSet<>(
//        Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
//    public String reverseVowels(String s) {
//        if (s == null) return null;
//        int i = 0, j = s.length() - 1;
//        char[] result = new char[s.length()];
//        while (i <= j) {
//            char ci = s.charAt(i);
//            char cj = s.charAt(j);
//            if (!vowels.contains(ci)) {
//                result[i++] = ci;
//            } else if (!vowels.contains(cj)) {
//                result[j--] = cj;
//            } else {
//                result[i++] = cj;
//                result[j--] = ci;
//            }
//        }
//        return new String(result);
//    }
    @Test
    void test() {
        ReverseVowels reverseVowels = new ReverseVowels();
        assertEquals("leotcede", reverseVowels.reverseVowels("algorlthm/leetcode"));
        assertEquals("holle", reverseVowels.reverseVowels("hello"));
    }


    public static void main(String[] args) {
        String s = "algorlthm/leetcode";
        char[] chars = new char[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            System.out.print(bytes[i] + ": ");
//        }
        int i = 0;
        chars[i+1] =  's';
        System.out.println(chars[0]);
        System.out.println(chars[1]);
    }


}
