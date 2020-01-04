package Generics.Demo.borderAndWildcards04;

/**
 * Created by jon on 17-1-15.
 * 15.10.4 铺货
 */
public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder);
    }

    public static void main(String[] args) {
        Holder<Integer> raw = new Holder<>(1);
        f1(raw);
        f2(raw);
        Holder rawBasic = new Holder();
        rawBasic.set(new Object());
        Holder<?> wildcarded = new Holder<Double>();
        f2(wildcarded);
    }
}
