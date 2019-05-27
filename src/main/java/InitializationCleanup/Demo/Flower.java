package InitializationCleanup.Demo;

import net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/29.
 * 5.4.1在构造器中调用构造器
 */


public class Flower {
    int petalCount = 0;
    String s = "initial value";

    public Flower(int petalCount) {
        this.petalCount = petalCount;
        Print.print("Constructor w/ int arg only , petalCount = " + petalCount);
    }

    public Flower(String s) {
        Print.print("Constructor w/ String arg only, s = " + s);
        this.s = s;
    }

    public Flower(String s, int petalCount) {
        this(petalCount);
        this.petalCount = petalCount;   //Another use of "this"
        this.s = s;
    }

    public Flower() {
        this("hi", 47);
        Print.print("default constructor(no args)");
    }

    void printPetalCount() {
        Print.print("petalCount = " + petalCount + "   s = " + s);
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}
