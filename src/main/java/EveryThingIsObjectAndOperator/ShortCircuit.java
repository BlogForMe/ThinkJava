package EveryThingIsObjectAndOperator;

import net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/7.
 * 3.8.1短路
 * 逻辑运算符
 * Demonstrates short-circuiting behavior with logical operators
 */
public class ShortCircuit {
    static boolean test1(int val) {
        Print.print("test1(" + val + ")");
        Print.print("result:" + (val < 1));
        return val < 1;
    }

    static boolean test2(int val) {
        Print.print("test2(" + val + ")");
        Print.print("result:" + (val < 2));
        return val < 2;
    }

    static boolean test3(int val) {
        Print.print("test3(" + val + ")");
        Print.print("result:" + (val < 3));
        return val < 3;
    }

    public static void main(String[] args) {
        boolean b = test1(0) && test2(2) && test3(2);
        Print.print("expression is" + b);
    }

}
