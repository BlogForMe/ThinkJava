package thinkjava.Demo;

import thinkjava.net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/29.
 */
class Bowl {
    public Bowl(int marker) {
        Print.print("Bowl  " + marker);
    }

    void f1(int marker) {
        Print.print("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);

    public Table() {
        Print.print("Table()");
        bowl2.f1(1);
    }

    void f2(int marker) {
//        TypeUtilities.getPrimitiveTypeByName("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    public Cupboard() {
        Print.print("Cupboard()");
        bowl4.f1(2);
    }

    void f3(int marker) {
        Print.print("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {
    public static void main(String[] args) {
        Print.print("Creating new Cupboard() in main");
        new Cupboard();
        Print.print("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}