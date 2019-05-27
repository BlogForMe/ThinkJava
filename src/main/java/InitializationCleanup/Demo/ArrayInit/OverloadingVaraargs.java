package InitializationCleanup.Demo.ArrayInit;


/**
 * Created by Jon on 2016/5/29.
 * 5.8.1 可变长数组
 */
public class OverloadingVaraargs {
    static void f(Character... args) {
        System.out.print("first");
        for (Character c : args)
            System.out.print(" " + c);
        System.out.println();
    }

    static void f(Integer... args) {
        System.out.print("second");
        for (Integer i : args) {
            System.out.print(" " + i);
            System.out.println();
        }
    }

    static void f(Long... args) {
        System.out.println("third");
    }

    public static void main(String[] args) {
        f('a', 'b', 'c');
        f(1);
        f(2, 1);
        f(0);
        f(0L);
    }
}
