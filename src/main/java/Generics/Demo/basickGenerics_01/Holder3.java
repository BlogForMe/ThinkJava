package Generics.Demo.basickGenerics_01;


/**
 * 与其使用Object，我们更喜欢暂时不指定类型
 */

public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
//        Holder3<Automobile> h3 = new Holder3<>(new Automobile());
//        Automobile a = h3.getA();
        Holder3<String> h3 = new Holder3<>("我是泛型");
        h3.setA("你好");
        System.out.println(h3.getA());
        Holder3<Integer> hh3 = new Holder3<>(1);
        System.out.println(hh3.getA());
    }
}
