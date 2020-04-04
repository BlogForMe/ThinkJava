package thinkjava.Generics.Demo.AnonymousInnerClass_03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jon on 2016/6/4.
 * 15.7.4
 */
public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<T>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<String>();
        List<String> stringList = stringMaker.create();
    }
}
