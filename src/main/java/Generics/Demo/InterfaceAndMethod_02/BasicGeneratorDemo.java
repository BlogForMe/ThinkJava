package Generics.Demo.InterfaceAndMethod_02;

import JavaConcurrency.demo.BasicThreadSyntax_01.LiftOff;
import net.mindview.util.Generator;

/**
 * Created by Jon on 2016/6/2.
 * 15.4创建CountedObject实例
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());


        Generator<LiftOff> cGen = BasicGenerator.create(LiftOff.class);

        for (int i = 0; i < 5; i++)
            System.out.println(cGen.next());

    }
}
