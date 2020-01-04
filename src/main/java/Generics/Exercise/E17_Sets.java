package Generics.Exercise;

import Generics.Demo.InterfaceAndMethod_02.Watercolors;
import net.mindview.util.Print;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/11.
 */
public class E17_Sets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(Watercolors.CERULEAN_BLUE_HUE, Watercolors.BURNT_UMBER);
        Print.print("set1 " + set1);
        Print.print("set2 " + set2);
    }
}


class Sets2 {
    protected static <T> Set<T> copy(Set<T> s) {
        if (s instanceof EnumSet)
            return ((EnumSet) s).clone();
        return new HashSet<>(s);
    }

    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = copy(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = copy(a);
        result.retainAll(b);
        return result;
    }

    //Subtract subset from superset:
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = copy(superset);
        result.removeAll(subset);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }


}
