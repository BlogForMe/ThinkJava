package thinkjava.typeinfo.Demo;

import thinkjava.net.mindview.util.Print;

/**
 * Created by jon on 17-2-7.
 * 14.7 动态代理
 */

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        Print.print("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        Print.print("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        Print.print("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        Print.print("SimpleProxy  somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
//        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
