package InitializationCleanup.Demo;

import net.mindview.util.Print;


/**
 * Created by Jon on 2016/5/29.
 * 5.7.4  非静态实例初始化
 * <p>
 * <p>
 * 会初始化两次   虽然没有静态对象
 */

class Mug {
    public Mug(int marker) {
        Print.print("Mug(" + marker + ")");
    }

    void f(int marker) {
        Print.print("f(" + marker + ")");
    }
}

public class Mugs {
    Mug mug1;
    Mug mug2;

    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        Print.print("mug1 & mug2 initialized");
    }

    Mugs() {
        Print.print("Mugs()");
    }

    Mugs(int i) {
        Print.print("Mugs(int)");
    }

    public static void main(String[] args) {
        Print.print("Inside main()");
        new Mugs();
        Print.print("new Mugs()  completed");
        new Mugs(1);
        Print.print("new Mugs(1) completed");
    }
}
/**
 * Inside main()
 * <p>
 * Mugs(1)
 * Mugs(2)
 * mug1 & mug2 initialized
 * <p>
 * Mugs()
 * new Mugs()  completed
 * <p>
 * Mugs(1)
 * Mugs(2)
 * mug1 & mug2 initialized
 * <p>
 * Mugs(int)
 * new Mugs(1) completed
 */
