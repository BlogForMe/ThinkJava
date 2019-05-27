package Generics.Exercise;

import net.mindview.util.Print;
import typeinfo.pets.EgyptianMau;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jon on 17-1-14.
 */
public class E24_Modify21 {
    public static void main(String[] args) {
        ClassTypeCapture3 ctt = new ClassTypeCapture3();
        ctt.addType("Widget", new Widget.Factory());
        ctt.addType("Integer", new IntegerFactory());
        Print.print(ctt.createNew("Integer", 1));
        Print.print(ctt.createNew("Widget", 2));
        ctt.createNew("Product", 3);

    }
}


class ClassTypeCapture3 {
    Map<String, FactoryI<?>> factories = new HashMap<>();

    public Object createNew(String typename, int arg) {
        FactoryI<?> f = factories.get(typename);
        try {
            return f.create(arg);  //必须要有无参的构造方法
        } catch (NullPointerException e) {
            Print.print("Not a registered typename: " + typename);
        } catch (Exception e) {
            Print.print(e.toString());
        }
        return null;
    }

    public void addType(String typename, FactoryI<?> factory) {
        factories.put(typename, factory);
    }

}