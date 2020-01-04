package test;

/**
 * Created by Administrator on 2017/2/14.
 */
public class Test1 {
    public int i, j;

    public void test_m(Test1 a) {
        Test1 b = new Test1();
        b.i = 1;
        b.j = 2;
        a = b;
    }

    public void test_m1(Test1 a) {
        a.i = 1;
        a.j = 2;
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        t.i = 5;
        t.j = 6;
        System.out.println(t.i + " " + t.j);
        t.test_m(t);
        System.out.println(t.i + " " + t.j);


        t.test_m1(t);
        System.out.println(t.i + " " + t.j);


    }
}
