package Generics.Demo.borderAndWildcards04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jon on 17-1-15.
 * <p>
 * 有点问题
 */
public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruit = new ArrayList<>();

    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());   //  没有报错
        //Incompatible types : found Fruit,required Apple
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
