package InitializationCleanup.Demo.ArrayInit;

import net.mindview.util.Print;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Jon on 2016/5/29.
 * 5.8.  数组初始化
 */
public class ArrayClassObj {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] a = new Integer[rand.nextInt(20)];
        Print.print("length of a =" + a.length);

        for (int i = 0; i < a.length; i++)
            a[i] = rand.nextInt(500);   // Autoboxing
        Print.print(Arrays.toString(a));
    }
}
