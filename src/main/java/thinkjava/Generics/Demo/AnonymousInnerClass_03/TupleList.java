package thinkjava.Generics.Demo.AnonymousInnerClass_03;

import thinkjava.Generics.Demo.InterfaceAndMethod_02.TupleTest;
import thinkjava.Generics.Demo.basickGenerics_01.Amphibian;
import thinkjava.Generics.Demo.basickGenerics_01.Vehicle;
import thinkjava.net.mindview.util.FourTuple;

import java.util.ArrayList;

/**
 * Created by Jon on 2016/6/3.
 * 15.6构建复杂模型
 * <p>
 * 这个不好做
 */


public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> t1 = new TupleList<>();
        t1.add(TupleTest.h());
        t1.add(TupleTest.h());
        for (FourTuple<Vehicle, Amphibian, String, Integer> i : t1)
            System.out.println(i);
    }
}



