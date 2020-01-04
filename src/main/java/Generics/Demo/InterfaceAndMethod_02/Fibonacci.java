package Generics.Demo.InterfaceAndMethod_02;

import net.mindview.util.Generator;

/**
 * Created by Jon on 2016/5/30.
 * 15.3   Fibonacci数列
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;


    protected static  int fib(int n) {
        if (n < 2) return 1;
        return fib((n - 2)) + fib(n - 1);
    }

    @Override
    public Integer next() {
        return fib(count++);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++)
            System.out.print(gen.next() + " ");
    }

}
