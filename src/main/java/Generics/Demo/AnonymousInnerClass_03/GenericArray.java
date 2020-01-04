package Generics.Demo.AnonymousInnerClass_03;

/**
 * Created by Jon on 2016/6/4.
 * 15.8.2泛型数组
 */
public class GenericArray<T> {
    private T[] array;

    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }


    //Method that exposes the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
//        Integer[] ia = gai.rep();//运行时，类型信息已经被擦除为object了
        //This is OK.
        Object[] oa = gai.rep();
    }
}
