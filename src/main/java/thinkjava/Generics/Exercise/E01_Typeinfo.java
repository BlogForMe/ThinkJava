package thinkjava.Generics.Exercise;

import thinkjava.Generics.Demo.basickGenerics_01.Holder3;
import thinkjava.typeinfo.pets.Dog;
import thinkjava.typeinfo.pets.Pet;

/**
 * Created by jon on 17-1-9.
 */
public class E01_Typeinfo {
    public static void main(String[] args) {
        Holder3<Pet> hc = new Holder3<>(new Dog("hehe"));
        System.out.println(hc.getA());
    }
}


