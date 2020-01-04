package Generics.Exercise;

/**
 * Created by jon on 17-1-14.
 */
public class E20_Main {
}

interface InteHas {
    void f();

    void m();
}

class ManipuHash implements InteHas {

    @Override
    public void f() {
        System.out.println("F()...");
    }

    @Override
    public void m() {
        System.out.println("m()...");
    }

    public void k() {
        System.out.println("k()...");
    }
}

class ManipuHash2 {
    static <T extends InteHas> void f(T x) {
        x.f();
        x.m();
    }

    public static void main(String[] args) {
        ManipuHash manipuHash = new ManipuHash();
        f(manipuHash);
    }

}