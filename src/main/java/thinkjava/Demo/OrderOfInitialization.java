package thinkjava.Demo;

import thinkjava.net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/29.
 * when the constructor is called to create a
 * Window object,you'll see a  message:
 */

class Window {
    public Window(int marker) {
        Print.print("Window(" + marker + ")");
    }
}

class House {
    Window w1 = new Window(1);

    public House() {
        //Show that we're in the constructor
        Print.print("House()");
        w3 = new Window(33);  //Reinitialize w3
    }

    Window w2 = new Window(2);  //After constructor

    void f() {
        Print.print("f()");
    }

    Window w3 = new Window(3);    //At end
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f();   //Shows that construction is done
    }
}
