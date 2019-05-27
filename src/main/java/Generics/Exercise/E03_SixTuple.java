package Generics.Exercise;


import Generics.Demo.basickGenerics_01.Amphibian;
import Generics.Demo.basickGenerics_01.Vehicle;
import net.mindview.util.FiveTuple;

/**
 * Created by Administrator on 2017/1/9.
 */
public class E03_SixTuple {
    static SixTuple<Vehicle, Amphibian, String, Integer, Integer, Double> j() {
        return new SixTuple<>(new Vehicle(), new Amphibian(), "dd", 33, 22, 35.0);
    }

    public static void main(String[] args) {
        System.out.println(j());
    }
}

class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {
    public final F sixth;

    public SixTuple(A a, B b, C c, D d, E e, F sixth) {
        super(a, b, c, d, e);
        this.sixth = sixth;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + "," + third + "," + fourth + "," + fifth + "," + sixth + ")";
    }
}
