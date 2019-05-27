package HoldingObject.Demo.ContainersAndList;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Jon on 2016/6/10.
 * 11.6.1  ListIterator
 */
public class ListIteration {
    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while ( it.hasNext())
            System.out.print(it.next() +", " + it.nextIndex() + "," + it.previousIndex() + "; " );
        System.out.println();

        //Backwards :
        while (it.hasPrevious())
            System.out.print(it.previous().id() + " ");
        System.out.println();
        System.out.println(pets);
        it  = pets.listIterator(3);
        while (it.hasNext()){
            it.next();
            it.set(Pets.randomPet());
        }
        System.out.println(pets);
    }
}
