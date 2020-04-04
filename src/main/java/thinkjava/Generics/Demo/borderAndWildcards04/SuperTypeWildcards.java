package thinkjava.Generics.Demo.borderAndWildcards04;


import java.util.List;

/**
 * Created by jon on 17-1-15.
 */
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Fruit());   Apple是下界，所以Fruit是不安全的
    }
}
