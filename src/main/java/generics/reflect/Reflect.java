package generics.reflect;

import thinkjava.typeinfo.pets.Person;

import java.lang.reflect.Constructor;

public class Reflect {
    public static void main(String[] args) throws Exception {

        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor();
        Person person = constructor.newInstance();

    }
}
