package thinkjava.Generics.Exercise;

/**
 * Created by jon on 17-1-15.
 */
public class E32_GenericCast {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<Integer> stack = new FixedSizeStack<>(1);
        stack.push(1);
        System.out.println(stack.pop());

        try {
            stack.pop();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }

        stack = new FixedSizeStack<>(1);
        stack.push(2);

        try {
            stack.push(2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }

    }
}


class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;

    public FixedSizeStack(int size) {
        storage = new Object[size];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    public T pop() {
        return (T) storage[--index];
    }
}

