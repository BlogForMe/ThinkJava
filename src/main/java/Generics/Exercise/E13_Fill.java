package Generics.Exercise;

import Generics.Demo.InterfaceAndMethod_02.Coffee;
import Generics.Demo.InterfaceAndMethod_02.CoffeeGenerator;
import Generics.Demo.InterfaceAndMethod_02.Fibonacci;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;

import java.util.*;


/**
 * Created by jon on 17-1-11.
 */
public class E13_Fill {

    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static <T> List<T> fill(List<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static <T> Set<T> fill(Set<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee)
            System.out.println(c);
        System.out.println();

        Queue<Integer> iQueue = fill(new LinkedList<>(), new Fibonacci(), 12);

        for (int i : iQueue)
            System.out.print(i + " ");
        System.out.println();
        LinkedList<Character> cLList = fill(new LinkedList<>(), new CountingGenerator.Character(), 12);
        for (char ch : cLList)
            System.out.print(ch);
        System.out.println();
        Set<Boolean> bSet = fill(new HashSet<>(), new CountingGenerator.Boolean(), 10);
        for (Boolean b : bSet)
            System.out.println(b);


    }


}
