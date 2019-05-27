package Generics.Demo.Qustion_05;

/**
 * Created by Administrator on 2017/1/16.
 */
class Subtype extends BasicHolder<Subtype> {
}

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype(), st2 = new Subtype();
        st1.set(st1);
        st2.set(st2);
        Subtype st3 = st1.get();
        st1.f();
    }
}

