package Generics.Exercise;

import Generics.Demo.borderAndWildcards04.Holder;
import net.mindview.util.Print;

/**
 * Created by jon on 17-1-15.
 */
public class E30_AutoboxingUnboxingTest {
    public static void main(String[] args) {
        Holder<Integer> hi = new Holder<>();
        hi.set(1);
        int i = hi.get();
        Print.print(i == 1);

        Holder<Byte> hb = new Holder<>();
        hb.set((byte) 1);
        byte b = hb.get();
        Print.print(b == 1);
    }
}
