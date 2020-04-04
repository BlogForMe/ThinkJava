package thinkjava.EveryThingIsObjectAndOperator;

import thinkjava.net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/8.
 * <p>
 * Test of unsigned right shift
 *
 * 不是很懂  有网的条件下 可以查一下资料
 */
public class URShift {
    public static void main(String[] args) {
//        int i = -1;
//        Print.print(Integer.toBinaryString(i));
//        i >>>= 10;
//        Print.print(Integer.toBinaryString(i));
//
//        long l = -1;
//        Print.print(Long.toBinaryString(l));
//        l >>>= 10;
//        Print.print(Long.toBinaryString(l));

//        short s = -1;
//        Print.print(Integer.toBinaryString(s));
//        System.out.println(Integer.toBinaryString(s).length());
//        s >>>= 10;
//        Print.print(Integer.toBinaryString(s));

        byte b = -1;
        Print.print(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b).length());
        b >>>= 10;
        Print.print(Integer.toBinaryString(b));

        b = -1;
        Print.print(Integer.toBinaryString(b));
        Print.print(Integer.toBinaryString(b >>> 10));


    }
}
