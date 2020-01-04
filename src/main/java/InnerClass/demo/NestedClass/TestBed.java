package InnerClass.demo.NestedClass;

/**
 * Created by Jon on 2016/6/12.
 * Putting test code in  a  nested class
 */
public class TestBed {
    public void f() {
        System.out.println("f()");
    }

    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}
