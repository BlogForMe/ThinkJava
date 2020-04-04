package thinkjava.EveryThingIsObjectAndOperator;

import thinkjava.net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/4.
 * 3.4.1 方法调用中的额别名问题
 */
//Passing objects to methods may not be what you're used to.
class Letter {
    char c;
}

public class PassObject {
    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        Print.print("1: x.c: " + x.c);
        f(x);
        Print.print("2:  x.c: " + x.c);
    }
}
