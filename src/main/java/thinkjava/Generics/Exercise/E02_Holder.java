package thinkjava.Generics.Exercise;


/**
 * Created by Jon on 2016/5/17.
 * 练习2
 */

public class E02_Holder {
    public static void main(String[] args) {
        Holder<String> h = new Holder<>("A", "B", "C");
        System.out.println(h.getA());
        System.out.println(h.getB());
        System.out.println(h.getC());
        h.setC("D");
        System.out.println(h.getC());
    }
}

class Holder<T> {
    private T a, b, c;

    public Holder(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }

    public T getC() {
        return c;
    }

    public void setC(T c) {
        this.c = c;
    }
}


