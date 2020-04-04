package thinkjava.Demo.GenericsAndBasic;

import java.util.ArrayList;

/**
 * Created by Jon on 2016/6/9.
 * 11.1 泛型和类型安全的容器
 * Simple container example(produces compiler warnings)
 */
class Apple {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}

class  Orange{}
public class ApplesAndOrangesWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Object> apples = new ArrayList<>();
        for (int i=0 ; i<3;i++)
            apples.add(new Apple());
        //Not prevented from adding an Orange to apple;
        apples.add(new Orange());
        for (int i=0;i<apples.size();i++)
            ((Apple)apples.get(i)).id();
        //Orange is detected only at run time
    }
}
