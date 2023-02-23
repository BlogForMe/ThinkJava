package jvm.deliver;

import pattern.uml.Person;

public class JavaValue {
    //测试
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("我是马化腾");
        p.setAge(45);
        PersonCrossTest(p);
        System.out.println("方法执行后的name：" + p.getName());
    }

    public static void PersonCrossTest(Person person) {
        System.out.println("Before new Person 传入的person的name：" + person.getName());
        person = new Person();
        System.out.println("After new Person 传入的person的name：" + person.getName());
        person.setName("我是张小龙");
        System.out.println("方法内重新赋值后的name：" + person.getName());
    }
}
