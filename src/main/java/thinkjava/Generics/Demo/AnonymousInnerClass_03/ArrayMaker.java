package thinkjava.Generics.Demo.AnonymousInnerClass_03;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Jon on 2016/6/4.
 * 15.7.4  边界处的动作
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
