package thinkjava.Generics.Demo.Qustion_05;

/**
 * Created by Administrator on 2017/1/16.
 */
public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A> {
}

class B extends SelfBounded<A> {
} //Also Ok

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {
}

class F extends SelfBounded {
}
