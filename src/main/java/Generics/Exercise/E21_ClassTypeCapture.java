package Generics.Exercise;

import net.mindview.util.Print;
import typeinfo.pets.Cat;
import typeinfo.pets.EgyptianMau;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jon on 17-1-14.
 */
public class E21_ClassTypeCapture {
    public static void main(String[] args) {
        ClassTypeCapture2 ctt = new ClassTypeCapture2();
        ctt.addType("Building", Building.class);
        ctt.addType("House", House.class);
        ctt.addType("Product", EgyptianMau.class);
        Print.print(ctt.createNew("Building").getClass());
        Print.print(ctt.createNew("House").getClass());
        ctt.createNew("Product").getClass();
        ctt.createNew("Car");


    }
}

class Building {
}

class House extends Building {
}

class ClassTypeCapture2 {
    Map<String, Class<?>> types = new HashMap<>();

    public Object createNew(String typename) {
        Class<?> cl = types.get(typename);
        try {
            return cl.newInstance();  //必须要有无参的构造方法
        } catch (NullPointerException e) {
            Print.print("Not a registered typename: " + typename);
        } catch (Exception e) {
            Print.print(e.toString());
        }
        return null;
    }

    public void addType(String typename, Class<?> kind) {
        types.put(typename, kind);
    }

}