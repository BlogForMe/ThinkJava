package thinkjava.Demo.ArrayInit;

/**
 * Created by Jon on 2016/5/29.\\
 * 5.8.1 可变长数组
 */
public class VaraargType {
    static void f(Character... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    static void g(int... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    public static void main(String[] args) {
        f('a');
        f();
        g(1);
        g();
        System.out.println("int[]" + new int[0].getClass());
    }
}
