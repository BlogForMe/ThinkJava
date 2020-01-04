package Generics.Demo.AnonymousInnerClass_03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jon on 2016/6/4.
 * 15.8.2泛型数组
 */
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<T>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
