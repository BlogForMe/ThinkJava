package Generics.Demo.AnonymousInnerClass_03;

/**
 * Created by Jon on 2016/6/4.
 * 15.8 擦除的补偿
 * 任何需要之道类型信息的操作都将无法工作
 */
public class Erased<T> {
    private final static int SIZE = 100;

    public static <T> void f(Object arg) {
//        if (arg instanceof T) {
//        }  //Error
//        T var = new T();
//        T[] array = new T[SIZE];
//        T[] array = (T) new Object[SIZE];
    }
}
