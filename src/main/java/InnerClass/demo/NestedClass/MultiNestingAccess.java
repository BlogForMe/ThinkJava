package InnerClass.demo.NestedClass;


/**
 * Created by Jon on 2016/6/12.
 * Nested classes can access all members of all
 */

class MNA {
    private void f() {
    }

    class A {
        private void g() {
            System.out.println("g()");
        }

        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
