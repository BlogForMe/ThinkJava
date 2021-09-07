package reflection;

import org.junit.Test;

import java.lang.reflect.Method;

public class InvokeTest {
    public void test(String[] arg){
        for (String string : arg) {
            System.out.println("zp is " + string);
        }
    }
    @Test
    public void invokeDemo() throws Exception {
        //获取字节码对象,这里要填好你对应对象的包的路径
        Class<InvokeTest> clazz = (Class<InvokeTest>) Class.forName("reflection.InvokeTest");
        //形式一：获取一个对象
//        Constructor con =  clazz.getConstructor();
//        InvokeTest m = (InvokeTest) con.newInstance();
        //形式二：直接new对象，实际上不是框架的话，自己写代码直接指定某个对象创建并调用也可以
        InvokeTest m = new InvokeTest();
        String[] s = new String[]{"handsome","smart"};
        //获取Method对象
        Method method = clazz.getMethod("test", String[].class); //invoke方法要比别的方法多做一步
        //调用invoke方法来调用
        method.invoke(m, (Object) s);
    }
}
