package Generics.Exercise;


/**
 * Created by Administrator on 2017/1/9.
 * <p>
 * 这里不好改
 */

public class E04_Sequence {
    public static void main(String[] args) {
        Sequence<Double> sequence = new Sequence<>(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Double.parseDouble(String.valueOf(i)));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}

class Sequence<T> {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(T x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector<T> implements Selector<T> {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public T current() {
            return (T) items[i];
        }

        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector<T> selector() {
        return new SequenceSelector();
    }

}

interface Selector<T> {
    boolean end();

    T current();

    void next();
}