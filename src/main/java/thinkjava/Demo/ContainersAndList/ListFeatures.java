package thinkjava.Demo.ContainersAndList;

import thinkjava.net.mindview.util.Print;
import thinkjava.typeinfo.pets.Cymric;
import thinkjava.typeinfo.pets.Hamster;
import thinkjava.typeinfo.pets.Pet;
import thinkjava.typeinfo.pets.Pets;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jon on 2016/6/10.
 * 11.5 List
 */
public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        ArrayList<Pet> pets = Pets.arrayList(7);
        Print.print("1:" + pets);
        Hamster h = new Hamster();
        pets.add(h);  //Automatically resizes
        Print.print("2: " + pets);
        Print.print("3" + pets.contains(h));
        pets.remove(h); //Remove by object
        Pet p = pets.get(2);
        Print.print("4: " + p + " " + pets.indexOf(p));
        Cymric cymric = new Cymric();
        Print.print("5:" + pets.indexOf(cymric));
        Print.print("6: " + pets.remove(cymric));
    }
}
