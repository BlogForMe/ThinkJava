package reflection.liao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * method方法实现
 * https://noteforme.github.io/2020/04/25/annotation/
 */
public class Main02 {
    public static void main(String[] args) {

        try {
            // 获取Person的hello方法:
            Method h = Person.class.getMethod("hello");
            // 对Student实例调用hello方法:
            h.invoke(new Student());

//            Class<Student> methodClass = Student.class;
            Class<Person> methodClass = Person.class;
            Arrays.stream(methodClass.getMethods()).forEach(method -> System.out.println("method方法:    " + method));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
