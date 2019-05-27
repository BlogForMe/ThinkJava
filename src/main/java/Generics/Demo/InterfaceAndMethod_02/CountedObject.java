package Generics.Demo.InterfaceAndMethod_02;

/**
 * Created by Jon on 2016/6/2.
 * 15.4简单的构造器的简单的类  generator
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    private long id() {
        return id;
    }

    public String toString() {
        return "CountedObject " + id;
    }

}
