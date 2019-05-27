package EveryThingIsObjectAndOperator;

import net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/8.
 * 3.13操作符重载
 */
public class StringOperators {
    public static void main(String[] args) {
        int x = 0, y = 1, z = 2;
        String s = "x , y ,z ";
        Print.print(s + x + y + z);
        Print.print(x + " " + s);  //Converts x to a String
        s += "(summed) = ";   //Concatenation  operator
        Print.print(s + (x + y + z));
        Print.print("" + x);  //Shorthand for Integer.toString()


    }
}
