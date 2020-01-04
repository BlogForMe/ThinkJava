package Generics.Exercise;

/**
 * Created by jon on 17-1-10.
 */
public class E10_GenericMethods {
    public <A, B> void f(A a, B b, Double c) {
        System.out.println(a.getClass().getName() + "   "
                + b.getClass().getName() + "  " + c.getClass().getName());
    }

    public static void main(String[] args) {
        E10_GenericMethods gm = new E10_GenericMethods();
        gm.f("1", 2, 4.0);
    }
}
