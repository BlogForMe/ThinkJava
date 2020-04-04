package thinkjava.Generics.Demo.AnonymousInnerClass_03;


import java.util.ArrayList;

/**
 * Created by Jon on 2016/6/3.
 * 15.7  擦除的神秘之处
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class<? extends ArrayList> c1 = new ArrayList<String>().getClass();
        Class<? extends ArrayList> c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
//        Class c1 = new ArrayList<String>().getClass();
//        Class c2 = new ArrayList<String>().getClass();
//        System.out.println(c1 == c2);
    }
}
