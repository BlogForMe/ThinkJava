package thinkjava.Generics.Demo.AnonymousInnerClass_03;

/**
 * Created by Jon on 2016/6/4.
 * 15.7 泛型擦除
 */
public class SimpleHolder {
    private Object obj;

    public void set(Object obj) {
        this.obj = obj;
    }

    public Object get() {
        return obj;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("Item");
        String s = (String) holder.get();
//        System.out.println(s);
    }
}
