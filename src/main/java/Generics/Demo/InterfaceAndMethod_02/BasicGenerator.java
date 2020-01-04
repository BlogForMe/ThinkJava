package Generics.Demo.InterfaceAndMethod_02;

import net.mindview.util.Generator;

/**
 * Created by Jon on 2016/6/2.
 * 15.4.4 一个通用的Generator
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

//    public BasicGenerator() {
//    }

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            // Assumes type is a  public class:
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    //Produce a Default generator given atype token :
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }
}
