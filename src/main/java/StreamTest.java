

import pattern.uml.Person;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        formMethod();
    }

    public static void formMethod() {
        List<Person> lists = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            lists.add(new Person("name"));
        }
        Long startTime = System.currentTimeMillis();
        lists.stream().forEach(user -> {
            System.out.println("__________stream处理____________" + user);
        });
        Long endTime = System.currentTimeMillis();
        System.out.println("time_total:" + (endTime - startTime));
    }
}
