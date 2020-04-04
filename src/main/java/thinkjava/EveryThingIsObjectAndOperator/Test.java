package thinkjava.EveryThingIsObjectAndOperator;

/**
 * Created by Jon on 2016/5/5.
 */
public class Test {
    public static void main(String[] args) {
        int a = 1, b = 1, i;
//         i = a++;
         i  = ++a;
        System.out.println(a==b);
    }
}
