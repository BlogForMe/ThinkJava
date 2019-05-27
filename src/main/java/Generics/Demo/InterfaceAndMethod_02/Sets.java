package Generics.Demo.InterfaceAndMethod_02;

import java.util.HashSet;
import java.util.Set;

/**
 * 15.4.6 一个Set实用工具
 * Created by Jon on 2016/6/2.
 */
public class Sets {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        HashSet<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        HashSet<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    //Subtract subset from superset:
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        HashSet<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }


}
