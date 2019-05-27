package HoldingObject.Demo.QueueAndCollection;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Created by Jon on 2016/6/11.
 * 11.12 Collection和Iterator
 */
public class CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = Pets.createArray(8);

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            public void remove() {  //Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public int size() {
        return pets.length;
    }

    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
