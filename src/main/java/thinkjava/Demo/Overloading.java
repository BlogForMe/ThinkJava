package thinkjava.Demo;

import thinkjava.net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/28.
 * Demonstration of both constructor
 */

class Tree {
    int height;
    Tree() {
        Print.print("Planting a seedling");
        height = 0;
    }

    Tree(int height) {
        this.height = height;
        Print.print("Creating new Tree that is" + height + " feet tall");
    }

    void info() {
        Print.print("Tree is " + height + " feet tall");
    }

    void info(String s) {
        Print.print(s + ":Tree is" + height + "feet tall");
    }
}

public class Overloading {
    public static void main(String[] args) {
        Tree t;
        for (int i = 0; i < 5; i++) {
            t = new Tree(i);
            t.info();
            t.info("overloaded method");
        }
        //Overloaded constructor:
        new Tree();
    }
}
