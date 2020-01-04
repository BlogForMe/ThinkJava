package Generics.Demo.borderAndWildcards04;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jon on 17-1-15.
 */
public class CompilerInterlligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0); //No warning
        flist.contains(new Apple()); //Argument is Object
        flist.indexOf(new Apple());  //Argument is Object
//        flist.add(new Apple());


    }
}
