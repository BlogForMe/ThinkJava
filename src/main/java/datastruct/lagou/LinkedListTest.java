package datastruct.lagou;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
    @SuppressWarnings(value = {"unused"})
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= 6; i++) {
            linkedList.add(i);
        }

        Iterator<Integer> iteratorList = linkedList.iterator();
//        while (iteratorList.hasNext())
//            System.out.println(iteratorList.next());

//        System.out.println(linkedList.size());

        Collection coll = new ArrayList();
    }
}
