package generics.arr;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayGeneric {
    public static void main(String[] args) {

//        ArrayList<String>[] listArr = new ArrayList[5];
//        ArrayList<Integer> intList = new ArrayList<>();
//        intList.add(100);
//
//
//        ArrayList<String> strList = new ArrayList<>();
//        strList.add("abc");
//        listArr[0] = strList;
//        String s = listArr[0].get(0);
//        System.out.println(s);


        FruitArr<String> fruit = new FruitArr<>(String.class,3);
        fruit.put(0,"苹果");
        fruit.put(1,"西瓜");
        fruit.put(2,"香蕉");
        String s1 = Arrays.toString(fruit.getArray());
        System.out.println(s1);

    }
}
