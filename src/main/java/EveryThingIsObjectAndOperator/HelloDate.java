package EveryThingIsObjectAndOperator;


/**
 * Created by Jon on 2016/5/4.
 * 2.7你的第一个Java程序
 */
public class HelloDate {
    public static void main(String[] args) {
//        System.out.println("Hello,it's");
//        System.out.println(new Date());
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));

    }
}
