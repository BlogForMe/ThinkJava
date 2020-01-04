package Generics.Demo.Qustion_05;

/**
 * Created by Administrator on 2017/1/16.
 */
public class SelfBoudingMethods {
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
    }
}
