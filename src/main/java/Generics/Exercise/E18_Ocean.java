package Generics.Exercise;

import Generics.Demo.InterfaceAndMethod_02.Generators;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Administrator on 2017/1/11.
 */
public class E18_Ocean {
    public static void serve(LittleFish t, BigFish c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        ArrayList<LittleFish> little = new ArrayList<>();
        Generators.fill(little, LittleFish.generator, 15);
        LinkedList<BigFish> line = new LinkedList<>();
        Generators.fill(line, BigFish.generator(), 4);
        for (LittleFish l : little)
            serve(l, line.get(rand.nextInt(line.size())));   //teller是随机给的
    }
}


class BigFish {
    private static long counter = 1;
    private final long id = counter++;

    public BigFish() {
    }

    @Override
    public String toString() {
        // A method produce Generator objects:
        return "BigFish " + id;
    }

    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}

class LittleFish {
    private static long counter = 1;
    private final long id = counter++;

    private LittleFish() {
    }

    @Override
    public String toString() {
        return "LittleFish " + id;
    }

    // A  single Gnerator object:
    public static Generator<LittleFish> generator = new Generator<LittleFish>() {
        @Override
        public LittleFish next() {
            return new LittleFish();
        }
    };
}