package pattern.proxy.headfirst;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NOnOwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    public NOnOwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {

        if (method.getName().startsWith("get")){
            return method.invoke(person,args);
        }else if (method.getName().equals("set")){
            throw new IllegalAccessException();
        }else if (method.getName().startsWith("setHotOrNotRating")){
            return method.invoke(person,args);
        }
        return null;
    }
}
