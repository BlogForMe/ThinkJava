package EveryThingIsObjectAndOperator;

import net.mindview.util.Print;

import java.util.Random;

/**
 * Created by Jon on 2016/5/4.
 * 3.5算术操作符
 * Demonstrates the mathematical operators.
 */
public class MathOps {
    public static void main(String[] args) {
        //Create a seeded random number generator:
        Random rand = new Random(47);
        int i, j, k;
        //Choose value form 1 to 100;
        j = rand.nextInt(100) + 1;
        Print.print("j : " + j);
        k = rand.nextInt(100) + 1;
        Print.print("k :" + k);

        i = j + k;
        Print.print("j + k :" + i);

        i = j - k;
        Print.print("j - k :" + i);
        i  = k /j;
        Print.print("j /k :" + i);

        i  = k * j;
        Print.print("j * k :" + i);

        i  = k % j;
        Print.print("j % k :" + i);

        j %= k;
        Print.print("j %= k :" + i);








    }
}
