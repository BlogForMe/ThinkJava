package InitializationCleanup.Demo.ArrayInit;

import net.mindview.util.Print;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Jon on 2016/5/29.
 * 5.8  数组初始化
 */
public class ArrayNew {
    public static void main(String[] args) {
        int [] a;
        Random rand = new Random(47);
        a  = new int[rand.nextInt(20)];
        Print.print("length of a = " + a.length);
        Print.print(Arrays.toString(a));
    }
}
