package thinkjava.typeinfo.Demo;

import thinkjava.net.mindview.util.Print;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/2/7.
 * 14.7 动态代理
 */
public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SelectingMethods.class.getClassLoader(), new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();

    }
}

class MethodSelector implements InvocationHandler {
    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting")){
            Print.print("Proxy detected the interesting method");
            Print.print(args[0]);
        }
        return method.invoke(proxied, args);   //代理方法
    }
}

interface SomeMethods {
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}

class Implementation implements SomeMethods {

    @Override
    public void boring1() {
        Print.print("boring1");
    }

    @Override
    public void boring2() {
        Print.print("boring2");
    }

    @Override
    public void interesting(String arg) {
        Print.print("interesting " + arg);
    }

    @Override
    public void boring3() {
        Print.print("boring3");
    }
}