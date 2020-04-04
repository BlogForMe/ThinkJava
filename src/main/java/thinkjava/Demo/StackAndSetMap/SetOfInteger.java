package thinkjava.Demo.StackAndSetMap;

import java.util.HashSet;
import java.util.Random;

/**
 * Created by Jon on 2016/6/11.
 * 11.9 Set
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        HashSet<Integer> intset = new HashSet<Integer>();
        for (int i = 0; i < 10000; i++)
            intset.add(rand.nextInt(30));
        System.out.println(intset);
    }
}
