package thinkjava.Generics.Demo.borderAndWildcards04;

/**
 * Created by jon on 17-1-15.
 * 15.10.3 无界通配符
 * 参数接收这个不理解
 */
public class Wildcards {
    //Raw argument:
    static void rawArgs(Holder holder, Object arg) {
        holder.set(arg);

        holder.set(new Wildcards());

        //Can't do this : don't have any 'T'
//        T t = holder.get();
        //Ok , but type information has been lost:
        Object obj = holder.get();
    }

    // Similar to rawArgs(),but errors instead of warnings:
    static void unboundedArg(Holder<?> holder, Object arg) {
//        holder.set(arg);  //Error:
//        holder.set(new Wildcards());
//        T t = holder.get();
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
//        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
//        T  t = holder.get();
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        //Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1l;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exact1(raw);

        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);  //Must return Object
        Long r4 = exact1(bounded);
        Long r5 = exact2(raw, lng);
        Long r6 = exact2(qualified, lng);
//        Long r7  = exact2(unbounded,lng); //Error  为啥不可以


//        Long r8 = exact2(bounded, lng); //Error
        Long r9 = wildSubtype(raw, lng);  //不理解
        Long r10 = wildSubtype(qualified, lng);
//         Long r11= wildSupertype(unbounded,lng);
        Long r12 = wildSubtype(bounded, lng);
    }

}
