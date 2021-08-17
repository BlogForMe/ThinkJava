package generics.extendsuper;


/**
 * 泛型擦除
 */


class GenericType<T> {
    Class<?> classType;

    public GenericType(Class<?> classType) {
        this.classType = classType;
    }

    public boolean isInstance(Object object) {
        return classType.isInstance(object);
    }
}

class A {
}

class B {
}


public class TypeRemove {
    public static void main(String[] args) {
        GenericType<A> genericType = new GenericType<>(A.class);
        System.out.println("---------");
        System.out.println(genericType.isInstance(new A()));
        System.out.println(genericType.isInstance(new B()));
    }
}





