package thinkjava.Generics.util;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/1/10.
 */
public class MyIterator implements Iterable<String> {
    String[] wList = "I HAVE A DREAM".split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < wList.length;
            }

            @Override
            public String next() {
                return wList[index++];
            }
        };
    }

    public static void main(String[] args) {

        for (String s : new MyIterator())
            System.out.println(s);

    }
}
