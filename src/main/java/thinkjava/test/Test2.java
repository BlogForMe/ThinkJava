package thinkjava.test;

/**
 * Created by Administrator on 2017/2/14.
 */
public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        D d = new D("男");
        C c = new C("张三", 20, d);

        System.out.println("before c" + c);

        C new_c = (C) c.clone();
        new_c.name = "李四";
//        d.sex = "女";
        System.out.println("after c" + c);
        System.out.println("after new_C" + new_c);
    }
}
class C implements Cloneable {
    String name;
    int age;
    D d;
    public C(String name, int age, D d) {
        this.name = name;
        this.age = age;
        this.d = d;
    }
    @Override
    public String toString() {
        return "C{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", d=" + d +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class D implements Cloneable {
    String sex;
    public D(String sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "D{" +
                "sex='" + sex + '\'' +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
