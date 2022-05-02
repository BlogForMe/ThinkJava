package generics.sgg;

import generics.extendsuper.Apple;
import generics.extendsuper.Food;
import generics.extendsuper.Fruit;
import org.junit.Test;

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
//        List<Fruit> list1 =  new ArrayList<Apple>();  //编译报错，泛型具体类型 List<Fruit> ,ArrayList<Apple> 不存在继承关系
        // ? extends Fruit 可以理解为 <= Fruit

        // List<? extends Fruit>                        //  可以作为 List<Apple> ， List<Fruit>的父类。
        List<? extends Fruit> list4 =  new ArrayList<Apple>();
        List<? extends Fruit> list5=  new ArrayList<Fruit>();
//        List<? extends Fruit> list5 =new ArrayList<Object>();    //编译报错，Object类不在 <= Fruit范围内

        /**
         * 只能读取数据 , 不能修改数据
         */

        Fruit fruit = list4.get(0);
//        Apple apple =list2.get(0); //编译不通过， <= Fruit范围，list1.get(0)实际类型可能是Fruit，是Apple的父类。
//        list1.add(new Apple()); //编译报错，<= Fruit范围， List<? extends Fruit>实际类型可能比是GreenApple,比Apple范围还小，随意存不了数据


        //--------------------------------------------------------------------------------//
        //只能修改数据，不能读取数据
        // <? super Fruit>

        List<? super Fruit> list6 = new ArrayList<Fruit>();  //   ? super Fruit 可以理解为 >= Fruit
        List<? super Fruit>  list7 = new ArrayList<Object>();


        Object object = list6.get(0); //理论上不能读取，但是都到Object还是可以的

//        Food food = list2.get(0); //编译不通过，>=Fruit范围，list2.get(0)实际类型可能是Object,不能赋值给小于它子类，所以只能是Object

        list6.add(new Fruit());
        list6.add(new Apple()); //
//        list6.add(new Food()); //   ? super Fruit范围是是 [Fruit,+∞), 所以Fruit范围内的都可以添加
    }

}
