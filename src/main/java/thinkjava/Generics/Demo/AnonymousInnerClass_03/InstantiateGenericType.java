package thinkjava.Generics.Demo.AnonymousInnerClass_03;

import thinkjava.net.mindview.util.Print;

/**
 * Created by Jon on 2016/6/4.
 * 15.8  擦除的补偿
 *
 * Integer没有默认的构造方法
 */
class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        Print.print("ClassAsFactory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            Print.print("ClassAsFactory<Integer> failed");
        }

    }
}
