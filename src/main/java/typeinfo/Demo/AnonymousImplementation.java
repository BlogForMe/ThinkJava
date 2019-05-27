package typeinfo.Demo;

import net.mindview.util.Print;
import typeinfo.interfacea.A;

/**
 * Created by Administrator on 2017/2/7.
 */
public class AnonymousImplementation {
    public static void main(String[] args) throws Exception {
        A a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        //Reflection still gets into the anonymous class:
        HiddenImplementation.callHiddenMethod(a,"g");
        HiddenImplementation.callHiddenMethod(a,"u");
        HiddenImplementation.callHiddenMethod(a,"v");
        HiddenImplementation.callHiddenMethod(a,"w");
    }
}


class AnonymousA {
    public static A makeA() {
        return new A() {

            @Override
            public void f() {
                Print.print("public C.f()");
            }

            public void g() {
                Print.print("public C.g()");
            }

            void u() {
                Print.print("package C.u()");
            }

            protected void v() {
                Print.print("protected C.v()");
            }

            private void w() {
                Print.print("private C.w()");
            }
        };
    }
}