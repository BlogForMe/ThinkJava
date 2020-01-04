package Generics.Exercise;

import Generics.Demo.InterfaceAndMethod_02.BasicGenerator;
import Generics.Demo.InterfaceAndMethod_02.CountedObject;
import net.mindview.util.Generator;

/**
 * Created by jon on 17-1-11.
 */
public class E14_BasicGeneratorDemo {
    public static void main(String[] args) {
//        Generator<CountedObject> gen = new BasicGenerator<>();

        Generator<CountedObject> gen = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
}
