package thinkjava.Demo.ArrayInit;


/**
 * Created by Jon on 2016/5/29.
 * Using array syntax to create variable argument list.
 */

class A {
};

public class VarArgs {
    static void printArray(Object[] args) {
        for (Object obj : args)
            System.out.print(obj + " ");
    }

    public static void main(String[] args) {
        printArray(new Object[]{new Integer(47), new Float(3.14), new Double(11.11)});
        printArray(new Object[]{"one", "two", "three"});
        printArray(new Object[]{new A(), new A(), new A()});
    }
}
