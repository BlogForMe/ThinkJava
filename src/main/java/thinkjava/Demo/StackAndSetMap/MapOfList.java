package thinkjava.Demo.StackAndSetMap;

import thinkjava.net.mindview.util.Print;
import thinkjava.typeinfo.pets.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jon on 2016/6/11.
 * Map
 */
public class MapOfList {
    public static Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();

    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"), new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"), Arrays.asList(new Pug("Louie aka Louis Snorketsteion Dupree")
                , new Cat("Stanford aka Stinky el Negro"), new Cat("Pinkola")));
        petPeople.put(new Person("Luke"), Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Issaac"), petPeople.put(new Person("Issac"), Arrays.asList(new Rat("Freckly"))));
    }

    public static void main(String[] args) {
        Print.print("People:" + petPeople.keySet());

    }
}
