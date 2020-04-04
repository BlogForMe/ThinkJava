package thinkjava.Demo.StackAndSetMap;

import java.util.Random;
import java.util.TreeSet;

/**
 * Created by Jon on 2016/6/11.
 */
public class SortedSetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        TreeSet<Integer> intset = new TreeSet<Integer>();
        for (int i = 0; i < 10000; i++)
            intset.add(rand.nextInt(30));
        System.out.println(intset);
    }
}
