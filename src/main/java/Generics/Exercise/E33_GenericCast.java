package Generics.Exercise;

import net.mindview.util.Print;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by jon on 17-1-15.
 */
public class E33_GenericCast {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack2<String> strings = new FixedSizeStack2<>(SIZE);
        for (String s : "A B C D E F G H I ".split(" "))
            strings.push(s);
        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            Print.print(s + " ");
        }
        Print.print();

        try {
            strings.pop();
        } catch (EmptyStackException e) {
            System.out.println(e.toString());
        }

        strings = new FixedSizeStack2<>(1);
        strings.push("A");

        try {
            strings.push("B");
        } catch (FullStackException e) {
            Print.print("Stack is full");
        }
    }
}

class FullStackException extends RuntimeException {
}

class FixedSizeStack2<T> {
    private int index = 0;
    private final int size;
    private List<T> storage;

    public FixedSizeStack2(int size) {
        storage = new ArrayList<>(size);
        this.size = size;
    }

    public void push(T item) {
        if (index < size) {
            index++;
            storage.add(item);
        } else
            throw new FullStackException();
    }

    public T pop() {
        if (index > 0)
            return storage.get(--index);
        throw new EmptyStackException();
    }
}