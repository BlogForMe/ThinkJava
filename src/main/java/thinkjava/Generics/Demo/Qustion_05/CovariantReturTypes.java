package thinkjava.Generics.Demo.Qustion_05;

/**
 * Created by Administrator on 2017/1/16.
 * 15.12.3 参数协变
 */
public class CovariantReturTypes {
    void test(DervivedGeeter d) {
        Derived d2 = d.get();
    }
}

class Base {
}

class Derived extends Base {
}

interface OrdinaryGetter {
    Base get();
}

interface DervivedGeeter extends OrdinaryGetter {
    //Return type of overridden method is allowed to vary:
    Derived get();
}
