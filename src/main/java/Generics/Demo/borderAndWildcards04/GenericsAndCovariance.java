package Generics.Demo.borderAndWildcards04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jon on 17-1-15.
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        //Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<Apple>();

        //Compile Error:can't add any type of object:
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());
        flist.add(null);  //Legal but uninteresting

        Fruit f = flist.get(0);
    }
}
