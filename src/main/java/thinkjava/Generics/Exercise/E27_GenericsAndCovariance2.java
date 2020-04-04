package thinkjava.Generics.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jon on 17-1-15.
 * 抄的答案
 */
public class E27_GenericsAndCovariance2 {
    public static void main(String[] args) {
//        List<Number> nlist = new ArrayList<Integer>();
        List<? extends Number> nlist = new ArrayList<Integer>();
//        nlist.add(new Integer(1));
//        nlist.add(new Float(1.0));
//        nlist.add(new Object());
        nlist.add(null);
        Number n = nlist.get(0);
    }
}
