package Generics.Demo.basickGenerics_01;

/**
 * Created by Jon on 2016/5/26.
 * generics
 */

class Automobile {
}

public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}
