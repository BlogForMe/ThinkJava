package generics.method;

public class Person3<T> {
    //泛型普通方法
    public void show(T name) {
        System.out.println(name + "正在演讲");
    }
    public <M> void show1(M name) {
        System.out.println(name + "正在演讲");
    }
    //静态泛型方法中的类型占位符和类中的泛型占位符是没有关系的
    public static <W> void show2(W name) {
        System.out.println(name + "：静态方法正在演讲!");
    }

    public static <E> E show3(E name) {
        return name;
    }
}
