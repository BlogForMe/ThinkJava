package thinkjava.Generics.Demo.InterfaceAndMethod_02;

import thinkjava.net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Jon on 2016/5/27.
 * 15.3 泛型接口实现
 * <p>
 * 实现了泛形接口，for循环代码可以编译成这个样子
 * CoffeeGenerator str = new CoffeeGenerator(5);
 * <p>
 * for (Iterator it = str.iterator(); it.hasNext();) {
 * <p>
 * System.out.println(it.next());
 * <p>
 * }
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    //For iteration:
    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {

        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove() {   // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
//        CoffeeGenerator gen = new CoffeeGenerator();
//        for (int i = 0; i < 5; i++)
//            System.out.println(gen.next());
//        for (Coffee c : new CoffeeGenerator(5))
//            System.out.println(c);            //为什么这里可以得到Coffee对象

        CoffeeGenerator str = new CoffeeGenerator(8);
        for (Iterator it = str.iterator(); it.hasNext(); )
            System.out.println(it.next());


    }

}
