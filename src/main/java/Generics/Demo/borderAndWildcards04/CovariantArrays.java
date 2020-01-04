package Generics.Demo.borderAndWildcards04;

/**
 * Created by jon on 17-1-15.
 * 15.10通配符
 */
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];  //只能放Apple或Apple的子集
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();

        /**
         * 下面存储的类型不是Apple或Apple的子集
         */
//        try {
//            fruit[0] = new Fruit();  //ArrayStoreException
//        } catch (Exception e) {
//            System.out.println(e);
//        }

//        fruit[0] = new Orange();  //ArrayStoreException


//        List<Fruit> flist = new ArrayList<Apple>();
    }
}

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}
