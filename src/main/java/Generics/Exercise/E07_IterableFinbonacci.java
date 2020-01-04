package Generics.Exercise;

import Generics.Demo.InterfaceAndMethod_02.Fibonacci;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/1/10.
 */


public class E07_IterableFinbonacci {
    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18))
            System.out.println(i + " ");
    }
}

class IterableFibonacci implements Iterable<Integer> {
    private Fibonacci fib = new Fibonacci();
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                --n;
                return fib.next();
            }

            public void remove() {  //Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
}

