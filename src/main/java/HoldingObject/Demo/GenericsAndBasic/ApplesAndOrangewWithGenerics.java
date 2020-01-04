package HoldingObject.Demo.GenericsAndBasic;

import java.util.ArrayList;

/**
 * Created by Jon on 2016/6/9.
 * 11.1泛型和类型安全的容器
 */
public class ApplesAndOrangewWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());
        //Complie - time error:
//        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++)
            System.out.println(apples.get(i).id());
        //Using foreach:
        for (Apple c : apples)
            System.out.println(c.id());
    }
}
