package generics.sgg;

import generics.extendsuper.Apple;
import generics.extendsuper.Fruit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest1 {

    @Test
    public void test1() {

        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型。
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(1122);


        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("order...");

        List<Object> list1 = null;
        List<String> list2 = null;
//        list1 = list2;
        List<String> list3 = null;
        ArrayList<Object> list4 = null;
//        list3 = list4;
    }


    @Test
    public void test2() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

//        print(list1);
//        print(list2);


        ArrayList<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入):对于List<?> 就不能向其添加数据，如果能添加数据，那定义泛型就没意义了。
        //除了添加null之外
//        list.add("MED");
//        list.add("?");
        list.add(null);

        //可以获取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);

    }


    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
        }

        list.forEach(o -> {
            System.out.println(o);
        });
    }


    @Test
    public void test4() {
        List<? extends Fruit> list1 = null;


        List<Apple> list3 = new ArrayList<>(); //  ? extends Fruit 可以理解为 <= Fruit
        List<Fruit> list4 = new ArrayList<>();  //List<? extends Fruit> 可以作为 List<Apple> ， List<Fruit>的父类。
        List<Object> list5 = new ArrayList<>();

//        list5 = list4; // 编译不通过

        list1 = list3;
        list1 = list4;

//        list1 = list5;    //编译报错，Object类不在 <= Fruit范围内

        /**
         * 读取数据 ,写入数据
         */

        Fruit fruit = list1.get(0);

//        Apple apple =list1.get(0); //编译不通过， <= Fruit范围，list1.get(0)实际类型可能是Fruit，是Apple的父类。

//        list1.add(new Apple()); //编译报错，<= Fruit范围， List<? extends Fruit>实际类型可能比是GreenApple,比Apple范围还小，随意存不了数据

        //--------------------------------------------------------------------------------//
        // <? super Fruit>


        List<? super Fruit> list2 = null;  //   ? super Fruit 可以理解为 >= Fruit
//       list2 = list3;                    //  编译报错,Apple类不在 >= Fruit范围内
        list2 = list4;
        list2 = list5;


        Object object = list2.get(0);

//        Food food = list2.get(0); //编译不通过，>=Fruit范围，list2.get(0)实际类型可能是Object,不能赋值给小于它子类，所以只能是Object

        list2.add(new Fruit());
        list2.add(new Apple()); //

//        list2.add(new Food()); //   ? super Fruit范围是是 [Fruit,+∞), 所以Fruit范围内的都可以添加
    }

}
