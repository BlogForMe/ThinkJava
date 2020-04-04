package thinkjava.EveryThingIsObjectAndOperator;

/**
 * Created by Jon on 2016/5/5.
 * 3。7.1 关系操作符
 */
public class EqualsValence {
    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);

        System.out.println(n1.equals(n2));
        System.out.println(n1);
        System.out.println(n2);
//        int n3=1 , n4=1;
//        int n5 = 1;
//        System.out.println(n3 == n4);
//        System.out.println(n4==n5);
    }
}
