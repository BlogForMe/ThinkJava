package typeinfo.interfacea;

/**
 * Created by Administrator on 2017/2/7.
 * 14.9 接口与类型信息
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
}

class B implements A {
    @Override
    public void f() {
    }

    public void g() {
    }
}