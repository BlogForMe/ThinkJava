package HoldingObject.Demo.ContainersAndList;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jon on 2016/6/10.
 * 11.6 迭代器
 */
public class SimpleIteration {
    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ": " + p + " ");
        }
        System.out.println();
        //A simpler approach , when possible :
        for (Pet p : pets)
            System.out.print(p.id() + ": " + p + " ");
        System.out.println();
        // An Iterator can also remove elements:
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }
}
