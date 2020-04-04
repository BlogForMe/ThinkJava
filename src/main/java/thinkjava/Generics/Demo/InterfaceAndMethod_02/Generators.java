package thinkjava.Generics.Demo.InterfaceAndMethod_02;

import thinkjava.net.mindview.util.Generator;

import java.util.Collection;

/**
 * Created by Jon on 2016/6/2.
 * 15.4.3 用于Generator的
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static void main(String[] args) {
//        Collection<Coffee> coffee = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
//        for (Coffee c : coffee)
//            System.out.println(c);
//        System.out.println();
//        Collection<Integer> fnumbers = fill(new ArrayList<>(), new Fibonacci(), 12);
//        for (int i : fnumbers)
//            System.out.print(i + " ,");

    }

}
