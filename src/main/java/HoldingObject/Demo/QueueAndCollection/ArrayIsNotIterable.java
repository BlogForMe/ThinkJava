package HoldingObject.Demo.QueueAndCollection;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Jon on 2016/6/12.
 * 11.13 Foreach与迭代器
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib)
            System.out.print(t + " ");
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        //An array works in foreach,but it's not Iterable:
//        test(strings);
        //You must explicitly convert it to an Iterable:
        test(Arrays.asList(strings));
    }
}
