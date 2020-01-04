package EveryThingIsObjectAndOperator;

/**
 * Created by Jon on 2016/5/5.
 * 3.7.2关系运算符
 */

class Vaule {
    int i;
}

public class EqualsMethod2 {
    public static void main(String[] args) {
        Vaule v1 = new Vaule();
        Vaule v2 = new Vaule();
        v1.i = v2.i = 100;
        System.out.println(v1.equals(v2));
        System.out.println(v1);
        System.out.println(v2);
    }
}
