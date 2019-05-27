package Generics.Demo.InterfaceAndMethod_02;


/**
 * Created by Jon on 2016/5/27.
 * 15.3泛型接口
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee {
};

class Mocha extends Coffee {
};

class Cappuccino extends Coffee {
};

class Americano extends Coffee {
};

class Breve extends Coffee {
};
