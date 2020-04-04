package thinkjava.typeinfo.Demo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jon on 17-2-7.
 * 14.7动态代理
 */
class  DynamicProxyHandler implements InvocationHandler{
   private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {    //proxy:对象的引用 ,method :被调用的方法 ，args:方法里面的参数
        System.out.println("**** proxy: " + proxy.getClass() + ". method: " +method + ", args " + args);
        if (args !=null)
            for (Object arg : args)                     //方法里面的参数
                System.out.println(" " + arg);
        return method.invoke(proxied,args);              //通过方法调用 引用和参数,转发调用
    }
}

public class SimpleDynamicProxy {
   public  static  void consumer(Interface iface){
       iface.doSomething();
       iface.somethingElse("bonobo");
   }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);                   //常用调用
        //Insert a proxy and cal again:
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},new DynamicProxyHandler(real));
        consumer(proxy);
   }
}
