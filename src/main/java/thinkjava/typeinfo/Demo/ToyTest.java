package thinkjava.typeinfo.Demo;

import thinkjava.net.mindview.util.Print;

/**
 * Created by Administrator on 2017/2/6.
 * 14.2 Class对象
 */
interface HasBatteries {}

interface Waterproof {}

interface Shoots {}

class Toy {
    //Comment out the following default constructor
    //to see NoSuchMethodError from(*1*)
    Toy() { }
    Toy(int i) { }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }

    void sing(){
        Print.print("sing()");
    }

}

public class ToyTest {
    static void printInfo(Class cc) {
        Print.print("Class name: " + cc.getName() + "     is Interface ?  [" + cc.isInterface() + "]");  //是否是接口
        Print.print("Simple name: " + cc.getSimpleName());       //不好含包名的类名
        Print.print("Canonical name : " + cc.getCanonicalName()); //全限定的类名
    }

    public static void main(String[] args) throws  Exception{
        Class c = null;
        try {
            c = Class.forName("thinkjava.typeinfo.Demo.FancyToy");
        } catch (ClassNotFoundException e) {
            Print.print("Can't find FancyToy");
            System.exit(1);
        }
        FancyToy fInstance = (FancyToy) c.newInstance();
        fInstance.sing();



//        Print.print(c);
//        printInfo(c);
//        Print.print();
//        for (Class face : c.getInterfaces()) {
//            printInfo(face);
//            Print.print();
//        }
//
//        Class up = c.getSuperclass();
//        Object obj = null;
//        try {
//            //Requires default constructor:
//            obj = up.newInstance();
//        } catch (InstantiationException e) {
//            Print.print("Cannot instantiate");
//            System.exit(1);
//        } catch (IllegalAccessException e) {
//            Print.print("Cannot access");
//            System.exit(1);
//        }
//        printInfo(obj.getClass());
    }
}


