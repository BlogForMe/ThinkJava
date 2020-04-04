package thinkjava.Demo.Enum;


/**
 * Created by Jon on 2016/5/29.
 * 为了使用 enum
 */
public class SimpleEnumUse {
    public static void main(String[] args) {
        Spiciness howHot = Spiciness.MEDIUM;
        System.out.println(howHot);

        for (Spiciness s : Spiciness.values())
            System.out.println(s + ", ordinal " + s.ordinal());
    }
}
