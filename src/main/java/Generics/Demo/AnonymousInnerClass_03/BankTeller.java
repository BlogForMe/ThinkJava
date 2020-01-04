package Generics.Demo.AnonymousInnerClass_03;

import Generics.Demo.InterfaceAndMethod_02.Generators;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Jon on 2016/6/3.
 * A  very simple bank teller simulation
 */

public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        LinkedList<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        ArrayList<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : line)
            serve(tellers.get(rand.nextInt(tellers.size())), c);   //teller是随机给的
    }
}


class Customer {
    private static long counter = 1;
    private final long id = counter++;

    public Customer() {
    }

    @Override
    public String toString() {
        // A method produce Generator objects:
        return "Customer " + id;
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    @Override
    public String toString() {
        return "Teller " + id;
    }

    // A  single Gnerator object:
    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}


