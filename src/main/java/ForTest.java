import thinkjava.typeinfo.pets.Person;

import java.util.ArrayList;
import java.util.Arrays;

public class ForTest {


    public static void main(String[] args) {

        formMethod();
        char[] chars = "ddd".toCharArray();
        Arrays.sort(chars);
        String.valueOf(chars);

        int[] count = new int[26];
        Arrays.fill(count,0);
    }

    public static void formMethod() {
        ArrayList<Person> lists = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            lists.add(new Person("name"));
        }

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 11; i++) {
            System.out.println("__________for处理____________ " + lists.get(i));
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("time_total:" + (endTime - startTime));
    }
}
