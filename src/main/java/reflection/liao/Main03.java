package reflection.liao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main03 {
    public static void main(String[] args) {
        try {
            Class<?> clz = Class.forName("reflection.liao.Person");
            Object o = clz.newInstance();
            Method methodGetName = clz.getMethod("getName");
            Object noParams = methodGetName.invoke(o);
            System.out.println(noParams);

            Method methodHello  = clz.getMethod("hello");
            System.out.println(methodHello.invoke(o));

            Method methodGetGrade = clz.getMethod("getGrade");
            System.out.println(methodGetGrade.invoke(o));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
