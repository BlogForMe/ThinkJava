package InitializationCleanup.Demo.ArrayInit;

import java.util.Arrays;

/**
 * Created by Jon on 2016/5/29.
 * Array initialization
 */
public class ArrayInit {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{new Integer(1), new Integer(2), 3};  // Autoboxing

        Integer[] b = new Integer[]{new Integer(1), new Integer(2), 3};

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
