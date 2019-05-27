package Generics.Demo.InterfaceAndMethod_02;

import java.util.Iterator;

/**
 * Created by Jon on 2016/5/30.
 * 15.3泛型接口 不是很理解
 * Iterable默认的forEach()  可以回调iterator()
 */
public class IterabelFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterabelFibonacci(int n) {
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
                n--;
                return IterabelFibonacci.this.next();
            }

            public void remove() {  // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterabelFibonacci(18))
            System.out.print(i + "  ");
    }
}
