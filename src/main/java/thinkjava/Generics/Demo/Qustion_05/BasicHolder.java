package thinkjava.Generics.Demo.Qustion_05;

/**
 * Created by Administrator on 2017/1/16.
 * 15.12.1  古怪的循环泛型
 */
public class BasicHolder<T> {
    T element;

    public T get() {
        return element;
    }

    public void set(T element) {
        this.element = element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
