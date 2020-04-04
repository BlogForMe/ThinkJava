package thinkjava.Generics.Demo.InterfaceAndMethod_02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jon on 2016/6/2.
 * 15.4.2  可变参数与泛型方法
 */
public class GenericVarargs {
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args)
            result.add(item);
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("QWERTYUOPAFDKLLXZCMM".split(""));
        System.out.println(ls);
    }
}
