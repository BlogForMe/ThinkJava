package thinkjava.Generics.Demo.AnonymousInnerClass_03;


/**
 * Created by Jon on 2016/6/4.
 * 15.8.2泛型数组
 */
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
//        gia = (Generic<Integer>[]) new Object[SIZE];
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
//        gia[1] = new Object();
//        gia[2] = new Generic<Double>();

    }
}

class Generic<T> {
}

class ArrayOfGenericReferecne {
    static Generic<Integer>[] gia;
}
