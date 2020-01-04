package InnerClass.demo.NestedClass;

/**
 * Created by Jon on 2016/6/12.
 * 10.7.1接口内部的类
 */
public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
