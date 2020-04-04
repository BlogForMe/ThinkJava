package thinkjava.Generics.Demo.InterfaceAndMethod_02;


import thinkjava.Generics.Demo.basickGenerics_01.Amphibian;
import thinkjava.Generics.Demo.basickGenerics_01.Vehicle;
import thinkjava.net.mindview.util.*;

/**
 * Created by Jon on 2016/6/2.
 * 下面是修改后的TupleTest  用来测试Tuple
 * <p>
 * <p>
 * f2()，返回的是非参数化的对象
 */
public class TupleTest2 {
    static TwoTuple<String, Integer> f() {
        return Tuple.tuple("hi", 47);
    }


    public static TwoTuple f2() {             //就这里不同
        return Tuple.tuple("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return Tuple.tuple(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static SixTuple l() {
        return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 47.0, 47f);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
        System.out.println(l());
    }

}
