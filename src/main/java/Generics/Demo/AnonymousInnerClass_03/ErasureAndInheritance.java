package Generics.Demo.AnonymousInnerClass_03;

/**
 * Created by Jon on 2016/6/3.
 * 擦除的问题
 */
class GenericBase<T> {
    private T element;

    public T get() {
        return element;
    }

    public void set(T element) {
        this.element = element;
    }
}

class Derived1<T> extends GenericBase<T> {
}

class Derived2 extends GenericBase {
} // No warning

//class  Dervived3 extends  GenericBase<?>{}

public class ErasureAndInheritance {
    public static void main(String[] args) {
        Derived1<String> derived1 = new Derived1<>();
        System.out.println(derived1.getClass().getTypeParameters());
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);  //没有报警告
    }
}