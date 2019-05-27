package Generics.Demo.AnonymousInnerClass_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Jon on 2016/6/3.
 * 15.7  擦除补偿
 * 只是用来作为参数占位符
 * <p>
 * 具体的类型信息都被擦除了
 * 唯一之道的就是在使用一个对象
 */


class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

class Particle<POSITION, MOMENTUM> {
}

public class LostInformation {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Fnorkle> p = new Particle<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));  //不能获得具体的String类型
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}
