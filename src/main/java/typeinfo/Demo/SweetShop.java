package typeinfo.Demo;

import net.mindview.util.Print;

/**
 * Created by Administrator on 2017/2/6.
 * 14.2 Class对象
 */


public class SweetShop {
    public static void main(String[] args) {
        Print.print("inside main");
        new Candy();
        Print.print("After creating Candy");
        try {
            Class.forName("TypeInfomation.Demo.Gum");
        } catch (ClassNotFoundException e) {
            Print.print("Couldn't find Gum");
        }
        Print.print("After Class.forName(Gum)");
        new Cookie();
        Print.print("After creating Cookie");
    }
}


class Candy {
    static {
        Print.print("Loading Candy");
    }
}

class Gum {
    static {
        Print.print("Loading Gum");
    }
}

class Cookie {
    static {
        Print.print("Loading Cookie");
    }
}

