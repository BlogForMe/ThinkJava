package thinkjava.Generics.Demo.AnonymousInnerClass_03;


/**
 * Created by jon on 17-1-14.
 */
public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipultor = new Manipulator<HasF>(hf);
        ReturnGenericType reGeneric = new ReturnGenericType(hf);
        System.out.println(reGeneric.get());
    }
}

class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}

class Manipultotor2<T extends HasF> {
    private T obj;

    public Manipultotor2(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }
}

class ReturnGenericType<T extends HasF> {
    private T obj;

    public ReturnGenericType(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }
}

class Manipulator<T> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    //Error:cannot find symbol:method f();
    public void manipulate() {
//        obj.f();
    }

    class Manipulator3 {
        private HasF obj;

        public Manipulator3(HasF obj) {
            this.obj = obj;
        }

        public void manipulate() {
            obj.f();
        }
    }


}
