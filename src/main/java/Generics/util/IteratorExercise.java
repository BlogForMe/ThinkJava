package Generics.util;


import java.util.*;

/**
 * 迭代器代码
 * Created by Administrator on 2017/1/10.
 */
public class IteratorExercise {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>();
        aList.add("I");
        aList.add("HAVE");
        aList.add("A");
        aList.add("DREAM");
        Iterator<String> it = aList.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
            aList.add("muy");
        }
    }
}


