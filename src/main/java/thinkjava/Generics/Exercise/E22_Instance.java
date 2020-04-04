package thinkjava.Generics.Exercise;

import thinkjava.typeinfo.pets.Cat;

/**
 * Created by jon on 17-1-14
 * 这个和答案有点不一样
 */


public class E22_Instance {
    public static void main(String[] args) {
        ClassAsFactory<Cat> c = new ClassAsFactory<>(Cat.class);
    }
}

class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
