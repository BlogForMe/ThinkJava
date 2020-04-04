package thinkjava.Demo;

import thinkjava.net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/28.
 * 5.2.2 设计基本类型的重载
 */
public class PrimitiveOverloading {
    void f1(char x) {
        Print.printnb("f1(char)");
    }

    void f1(byte x) {
        Print.printnb("f1(byte)");
    }

    void f1(short x) {
        Print.printnb("f1(short)");
    }

    void f1(int x) {
        Print.printnb("f1(int)");
    }

    void f1(float x) {
        Print.printnb("f1(float)");
    }

    void f1(double x) {
        Print.printnb("f1(double)");
    }



    void f2(byte x) {
        Print.printnb("f2(byte)");
    }

    void f2(short x) {
        Print.printnb("f2(short)");
    }

    void f2(int x) {
        Print.printnb("f2(int)");
    }

    void f2(long x) {
        Print.printnb("f2(long)");
    }

    void f2(float x) {
        Print.printnb("f2(float)");
    }

    void f2(double x) {
        Print.printnb("f2(double)");
    }

    void f3(short x) {
        Print.printnb("f3(short)");
    }

    void f3(int x) {
        Print.printnb("f3(int)");
    }

    void f3(long x) {
        Print.printnb("f3(long)");
    }

    void f3(float x) {
        Print.printnb("f3(float)");
    }

    void f3(double x) {
        Print.printnb("f3(double)");
    }

    void f4(int x) {
        Print.printnb("f4(int)");
    }

    void f4(long x) {
        Print.printnb("f4(long)");
    }

    void f4(float x) {
        Print.printnb("f4(float)");
    }

    void f4(double x) {
        Print.printnb("f4(double)");
    }


    void f5(long x) {
        Print.printnb("f5(long)");
    }

    void f5(float x) {
        Print.printnb("f5(float)");
    }

    void f5(double x) {
        Print.printnb("f5(double)");
    }

    void f6(float x) {
        Print.printnb("f6(float)");
    }

    void f6(double x) {
        Print.printnb("f6(double)");
    }

    void f7(double x) {
        Print.printnb("f7(double)");
    }

    void testConstVal() {
        Print.printnb("5 :");
        f1(5);
        f2(5);
        f3(5);
        f4(5);
        f5(5);
        f6(5);
        f7(5);
        Print.print();
    }

    void testChar() {
        char x = 'x';
        Print.printnb("char: ");
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
    }

    public static void main(String[] args) {
        PrimitiveOverloading p = new PrimitiveOverloading();
//        p.testConstVal();
        p.testChar();
    }

}
