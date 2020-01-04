package InitializationCleanup.Demo;

/**
 * Created by Jon on 2016/5/29.
 * 5.4  this关键字
 */

class Banana {
    void peel(int i) {

    }
}

public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(),
                b = new Banana();
        a.peel(1);
        b.peel(1);
    }
}
