package Generics.test;

import java.util.Iterator;

/**
 * Created by jon on 17-1-9.
 */
public class MyIterable implements Iterable<String> {
    protected String[] words = "I  HAVE  A DREAM ".split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new MyIterable())
            System.out.print(s + " ");
    }
}
