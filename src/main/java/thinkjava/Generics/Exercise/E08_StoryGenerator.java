package thinkjava.Generics.Exercise;


import thinkjava.net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by jon on 17-1-10.
 */
public class E08_StoryGenerator
        implements Generator<StroyCharacters>, Iterable<StroyCharacters> {
    private Class[] characters = {ElonMusk.class, BillGates.class, LaliPage.class, Putin.class, SuiLuosi.class};
    private static Random rand = new Random(47);


    //For iteration:
    private int size = 0;

    public E08_StoryGenerator(int size) {
        this.size = size;
    }

    public StroyCharacters next() {
        try {
            return (StroyCharacters) characters[rand.nextInt(characters.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CharacterIterator implements Iterator<StroyCharacters> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public StroyCharacters next() {
            count--;
            return E08_StoryGenerator.this.next();
        }
    }

    @Override
    public Iterator<StroyCharacters> iterator() {
        return new CharacterIterator();
    }

    public static void main(String[] args) {
        for (StroyCharacters s : new E08_StoryGenerator(7))
            System.out.println(s);
    }

}

class StroyCharacters {
    private static long counter = 0;
    protected final long id = counter++;


}

class GoodGuy extends StroyCharacters {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "  I am good guy  " + id;
    }
}

class BadGuy extends StroyCharacters {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "  I am bad guy  " + id;
    }
}

class ElonMusk extends GoodGuy {
}

class BillGates extends GoodGuy {
}

class LaliPage extends GoodGuy {
}

class Putin extends BadGuy {
}

class SuiLuosi extends BadGuy {
}


