package thinkjava.Generics.Demo.AnonymousInnerClass_03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jon on 2016/6/4.
 * 15.7.4  边界处的神秘动作
 */
public class FilledListMaker<T> {
    List<T> create(T t, int n) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            result.add(t);

        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringMaker = new FilledListMaker<>();
        List<String> list = stringMaker.create("Hello", 4);
        System.out.println(list);
    }
}
