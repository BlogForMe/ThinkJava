package Generics.Demo.InterfaceAndMethod_02;


import Generics.Demo.basickGenerics_01.Amphibian;
import Generics.Demo.basickGenerics_01.Vehicle;
import net.mindview.util.*;

/**
 * 本来在上一个简单泛型包里  为了使用方便拿到这里来了
 * Created by Jon on 2016/5/17.
 * 15.2.1   一个元组类库
 */


public class TupleTest {
    public static net.mindview.util.TwoTuple<String, Integer> f() {
        //Autoboxing converts the int to Integer
        return new TwoTuple<>("hi", 47);
    }

    public static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(new Amphibian(), "hi", 47);
    }

    public static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    public static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static SixTuple<Vehicle, Amphibian, String, Integer, Integer, Double> i() {
        return new SixTuple(new Vehicle(), new Amphibian(), "hi", 11, "11", 11.1);
    }

    public static void main(String[] args) {
        System.out.println(f());
        System.out.println(g());
        System.out.println(k());
        System.out.println(i());

    }
}
