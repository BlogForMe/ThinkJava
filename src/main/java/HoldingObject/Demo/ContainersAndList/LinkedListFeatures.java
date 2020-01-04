package HoldingObject.Demo.ContainersAndList;

import net.mindview.util.Print;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.LinkedList;

/**
 * Created by Jon on 2016/6/11.
 */
public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
        Print.print(pets);
        // Indentical:
        Print.print("pets.getFirst(): " + pets.getFirst() );
        Print.print("pets.elements():" + pets.element());

        //Only differs in empty-list behavior:
        Print.print("pet.peek():" + pets.peek());
        //Identical ; remove and return the first
    }
}
