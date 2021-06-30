package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 反射读取注解的信息，模拟处理注解信息流程
 */
public class Demo03 {
    public static void main(String[] args) {

        try {
            Class clazz = Class.forName("annotation.SxtStudent");

            //获得类的所有有效注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a:annotations){
                System.out.println(a);
            }
            //获得类的指定注解
            SxtTable st = (SxtTable)clazz.getAnnotation(SxtTable.class);
            System.out.println(st.value());

            //获得类的属性的注解
            Field f = clazz.getDeclaredField("studentName");
            SxtField sxtField = f.getAnnotation(SxtField.class);
            System.out.println(sxtField.columnName()+"--" + sxtField.type()+"---" + sxtField.length());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
