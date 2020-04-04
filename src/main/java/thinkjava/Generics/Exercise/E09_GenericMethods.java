package thinkjava.Generics.Exercise;

/**
 * Created by jon on 17-1-10.
 */
public class E09_GenericMethods {
    public <A, B, C> void f(A a, B b, C c) {
        System.out.println(a.getClass().getName() + "   "
                + b.getClass().getName() + "  " + c.getClass().getName());
    }

    public static void main(String[] args) {
        E09_GenericMethods gm = new E09_GenericMethods();
        gm.f("1", 2, 4.0);
    }
}
