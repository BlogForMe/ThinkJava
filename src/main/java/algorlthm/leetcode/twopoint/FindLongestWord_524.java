package algorlthm.leetcode.twopoint;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FindLongestWord_524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String maxStr = "";//初始化
        for(String dic : dictionary){
            if (singlePattren(s,dic)){
                if (dic.length()>maxStr.length()||(maxStr.length()==dic.length()&&dic.compareTo(maxStr)<0)){
                    maxStr = dic;
                }
            }
        }
        return maxStr;
    }

//      这种方式流程太长了
//    public String findLongestWord(String s, List<String> dictionary) {
//        for (int i = 0; i < dictionary.size(); i++) {
//            boolean isMartch = singlePattren(s, dictionary.get(i));
//            if (!isMartch) {
//                dictionary.set(i, null);
//            }
//        }
//        Collections.sort(dictionary, Comparator.nullsLast(String::compareTo));
//        System.out.println(dictionary);
//        if (dictionary.size() > 0) {
//            return dictionary.get(0);
//        }
//        Print.printArr(dictionary);
//        return "";
//    }

    private boolean singlePattren(String s, String dic) {
        int sLength = s.length();
        int dicLength = dic.length();
        int sIndex = 0;
        int dicIndex = 0;

        while (sIndex < sLength && dicIndex < dicLength) {
            if (s.charAt(sIndex) == dic.charAt(dicIndex)) {
                sIndex++;
                dicIndex++;
            } else {
                sIndex++;
            }
        }
        if (dicIndex == dicLength) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        for (Integer data:list){
//            list.set(0,9);
//        }
//        System.out.println(list);



//        assertArrayEquals(arr);
//        System.out.println(ff);
    }


    @Test
    void test() {
        String[] d = new String[]{"ale", "apple", "monkey", "plea"};


        FindLongestWord_524 findWord = new FindLongestWord_524();
//        assertEquals("apple",findWord.findLongestWord("abpcplea", Arrays.asList(d)));
        assertEquals("a",findWord.findLongestWord("abpcplea", Arrays.asList(new String[]{"a","b","c"})));
    }
}
