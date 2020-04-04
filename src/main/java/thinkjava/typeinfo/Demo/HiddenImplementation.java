package thinkjava.typeinfo.Demo;

import thinkjava.typeinfo.interfacea.A;
import thinkjava.typeinfo.packageaccess.HiddenC;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/2/7.
 * 14.9 接口与类型信息
 */
public class HiddenImplementation {
    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }

    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
//        a.f();
//        System.out.println(a.getClass().getName());

//        if (a instanceof  C){   //包外访问不了 C
//        a.g();
//        }
         // Oops! Reflection still allows us to call g();
        callHiddenMethod(a,"g");
        //And even methods that are less access accessible!
        callHiddenMethod(a,"u");
        callHiddenMethod(a,"v");
        callHiddenMethod(a,"w");   //private方法都能调用
    }
}
