package Generics.Demo.AnonymousInnerClass_03;

/**
 * Created by Jon on 2016/6/4.
 * 15。8擦除的补偿
 */
abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();     //会先调用父类的构造方法   ，生成X对象
    }

    abstract T create();
}

class X {
}

class Creator extends GenericWithCreate<X> {
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }

}

public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}
