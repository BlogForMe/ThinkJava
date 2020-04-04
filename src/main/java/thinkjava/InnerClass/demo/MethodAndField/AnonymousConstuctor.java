package thinkjava.InnerClass.demo.MethodAndField;

import thinkjava.net.mindview.util.Print;

/**
 * Created by Jon on 2016/6/12.
 * Creating a constructor for an  anonymous
 */

abstract class Base {
    public Base(int i) {
        Print.print("Base constructor , i = " + i);
    }

    public abstract void f();
}

public class AnonymousConstuctor {
    public static Base getBase(int i) {
        return new Base(i) {
            {
                Print.print("Inside instance initializer");
            }

            @Override
            public void f() {
                Print.print("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
