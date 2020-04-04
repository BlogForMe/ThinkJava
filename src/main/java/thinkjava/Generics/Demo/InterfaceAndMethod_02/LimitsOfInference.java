package thinkjava.Generics.Demo.InterfaceAndMethod_02;

import thinkjava.JavaIo.Demo.XML_04.Person;
import thinkjava.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * Created by jon on 17-1-10.
 * 这个现在可以通过编译
 */
public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {
    }

    public static void main(String[] args) {
//        f(New.map());
    }
}
