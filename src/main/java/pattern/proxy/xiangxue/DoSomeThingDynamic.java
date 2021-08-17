package pattern.proxy.xiangxue;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DoSomeThingDynamic {
    Object object;

    public DoSomeThingDynamic(Object object) {
        this.object = object;
    }

    /**
     *
     * @param say 需要代理执行的接口类
     * @param <T>
     * @return 动态代理 运行时生成的一个say对应类型的类，用于调用say接口的时候 运行
     */
    public <T> T create(final Class<T> say){
        return (T) Proxy.newProxyInstance(say.getClassLoader(),
                new Class<?>[]{say},
                new InvocationHandler() {
                    //method这个函数是 反射的函数， method具体代表的是 代理在执行的当前的函数
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        System.out.println("拍电影前的准备工作");
                        Object result = method.invoke(object, args); //等价于 zhangYuXin.sayHello();
                        System.out.println("拍电影后的收尾工作");
                        return result;
                    }
                }
        );
    }
}
