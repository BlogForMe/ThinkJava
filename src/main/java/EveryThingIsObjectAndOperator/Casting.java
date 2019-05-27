package EveryThingIsObjectAndOperator;

import net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/8.
 * 3.15 类型转换操作符
 */
public class Casting {
    public static void main(String[] args) {
//        int i = 200;
//
//        long lng = (long) i;
//        lng = i; // "Widening."  so cast not really required
//        long lng2 = (long) 2000;
//        lng2 = 200;
//        //A "narrowing conversion":
//        i = (int) lng2; // Cast required

        //3.15.1 截尾和舍入
        //What happens when you cast a float or double to an integral value?
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;
        Print.print("(int)above: " + (int) above);
        Print.print("(int)below: " + (int) below);
        Print.print("(int)fabove: " + (int) fabove);
        Print.print("(int)fblow: " + (int) fbelow);

        //Rounding floats and doubles.
        Print.print("Math.round(above):" + Math.round(above));
        Print.print("Math.round(below):" + Math.round(below));
        Print.print("Math.round(fabove):" + Math.round(fabove));
        Print.print("Math.round(fbelow):" + Math.round(fbelow));


    }
}
