package InitializationCleanup.Demo.ArrayInit;

import net.mindview.util.Print;

/**
 * Created by Jon on 2016/5/29.
 * 5.8 数组的初始化
 */
public class ArraysOfPrimitives {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        for (int i = 0; i < a2.length; i++)
            a2[i] = a2[i] + 1;

        for (int i = 0; i < a1.length; i++)
            Print.print("a1[" + i + "] = " + a1[i]);
    }
}
