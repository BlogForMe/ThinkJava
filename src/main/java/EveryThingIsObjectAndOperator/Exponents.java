package EveryThingIsObjectAndOperator;

/**
 * Created by Jon on 2016/5/7.
 * 3.9.1  指数记数法
 * <p>
 * "e"  means "1o to the power."
 */
public class Exponents {
    public static void main(String[] args) {
        //Uppercase and lowercase "e" are the same:
        float expFloat = 1.39e-43f;
        expFloat = 1.39E-43f;
        System.out.println(expFloat);

        double expDdouble = 47e47d;  // 'd' is optional
        double expDouble2 = 47e47;   // Automatically double
        System.out.println(expDdouble);
    }
}
