package thinkjava.Demo;

import thinkjava.net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/29.
 * 5.7.3 显示的静态初始化
 */

class Cup {
    public Cup(int marker) {
        Print.print("Cup(" + marker + ")");
    }

    void f(int marker) {
        Print.print("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    public Cups() {
        Print.print("Cups()");
    }

}

public class ExplicStatic {
    public static void main(String[] args) {
        Print.print("Inside main()");
        Cups.cup1.f(99);
    }
    static  Cups cups1 = new Cups();
    static  Cups cups2 = new Cups();
}


/***
 *
 *    我认为的结果是下面这样的  OK
 *    Cup(1)
 *    Cup(2)
 *    Cups()
 *    Cups()
 *    Inside main()
 *    f(99)
 */
