package HoldingObject.Demo.GenericsAndBasic;

import java.util.ArrayList;

/**
 * Created by Jon on 2016/6/9.
 * 11.2基本概念
 */
public class SimpleCollection {
    public static void main(String[] args) {
        ArrayList<Integer> c = new ArrayList<Integer>();
        for (int i=0;i<10;i++)
            c.add(i);  //Autoboxing
        for (Integer i : c)
            System.out.print(i + ", ");

    }
}
