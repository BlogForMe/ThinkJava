package thinkjava.Generics.Exercise;


/**
 * Created by jon on 17-1-14.
 * <p>
 * 和答案也有区别
 */
public class E23_FacConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}

interface FactoryI<T> {
    T create(Integer arg);
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create(0);
    }
}

class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create(Integer arg) {
        return new Integer(0);
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {

        @Override
        public Widget create(Integer arg) {
            return new Widget();
        }
    }
}
