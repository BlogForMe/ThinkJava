package thinkjava.InnerClass.demo.BasicInner;

/**
 * Created by Jon on 2016/6/7.
 * 10.3使用.this 与 .new
 * <p>
 * Qualifying access to the outer-clas object.
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
        //A plain "this" would be Inner's "this"
    }

    public Inner inner() {
        return new Inner();
    }


    public static void main(String[] args) {
        DotThis dt = new DotThis();
        Inner dti = dt.inner();
        dti.outer().f();
    }

}
