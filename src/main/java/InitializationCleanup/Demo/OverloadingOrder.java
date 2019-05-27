package InitializationCleanup.Demo;

import net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/28.
 * Overloading  based on the order of the arguments
 */
public class OverloadingOrder {
    static void f(String s, int i) {
        Print.print("String : " + s + ". int: " + i);
    }

    static void f(int i, String s) {
        Print.print("int : " + i + ", String:" + s);
    }

    public static void main(String[] args) {
        f("String first", 11);
        f(99, "Int first");
    }
}
