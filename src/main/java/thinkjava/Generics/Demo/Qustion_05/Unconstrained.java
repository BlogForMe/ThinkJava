package thinkjava.Generics.Demo.Qustion_05;

/**
 * Created by Administrator on 2017/1/16.
 * 15.12.2 自限定
 */
public class Unconstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther(), b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}

class Other {
}

class BasicOther extends BasicHolder<Other> {
}
