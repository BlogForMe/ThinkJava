package InnerClass.demo.MethodAndField;

import net.mindview.util.Print;

/**
 * Created by Jon on 2016/6/12.
 * 10.6.1 再访工厂方法
 */
interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    private Implementation1() {
    }

    @Override
    public void method1() {
        Print.print("Implementation1 method1");
    }

    @Override
    public void method2() {
        Print.print("Implementation1 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service {

    @Override
    public void method1() {
        Print.print("Implementation2 method1");
    }

    @Override
    public void method2() {
        Print.print("Implementation2 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}

public class Factoryies {
    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        //Implementations  are completely interchangeable:
        serviceConsumer(Implementation2.factory);

    }
}