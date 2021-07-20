package pattern.uml.dependence;

/**
 * 1. 类中用到了对方。
 * 2. 如果是类的成员属性。
 * 3. 如果是方法的返回类型。
 * 4. 是方法接收的参数类型。
 * 5. 方法中使用到。
 */
public class PersonServiceBean {
    private PersonDao personDao;

    public void save(Person person) {
    }

    public void modify() {
        Department department = new Department();
    }
}


class PersonDao {
}

class IdCard {
}

class Person {
}

class Department {
}