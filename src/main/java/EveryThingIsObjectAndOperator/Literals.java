package EveryThingIsObjectAndOperator;

import net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/7.
 * 3.9直接常量
 */
public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f; // Hexadecimal(lowercase)
        Print.print("i1 :" + Integer.toBinaryString(i1));

        int i2 = 0x2F; //
        Print.print("i2: " + Integer.toBinaryString(i2));

        int i3 = 0177; //Octal(leading zero)
        Print.print("i3: " + Integer.toBinaryString(i3));
        char c = 0xffff; //max char hex value
        Print.print("c: " + Integer.toBinaryString(c));

        byte b = 0x7f;//max byte hex value
        Print.print("b: " + Integer.toBinaryString(b));

        short s = 0x7fff;
        Print.print("s: " + Integer.toBinaryString(s));

        long n1 = 200L; //long suffix
        long n2 = 200l; //long suffix(but can be confusing)
        long n3 = 200;
        float f1 = 1;
        float f2 = 1F;  //float suffix
        float f3 = 1f;  //float suffix
        double d1 = 1d; //double suffix
        double d2 = 1D;  //double suffix

        //(Hex and Octal also work with long)
    }


}
