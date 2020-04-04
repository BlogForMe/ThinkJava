package thinkjava.test;

import java.util.Random;

/**
 * Created by Jon on 2016/5/25.
 */

class Value {
    int i; //Package access

    public Value(int i) {
        this.i = i;
    }
}

public class FinalData {
    private static Random rand = new Random();
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    //Can be compile-time constants;
    private final int valueOne = 9;
    private static final int VALUE_THREE = 39;


    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);


    //Arrays:
    private final int[] a = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
//        fd1.valueOne++;     //Error: cant't chagne value
        int vv = fd1.v2.i++;    // Object isn't constant!

        fd1.v1 = new Value(9);
        System.out.println(fd1.v1.i);

        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;  // Object isn
        }
    }
}
