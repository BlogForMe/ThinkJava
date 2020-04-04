package thinkjava.Demo.ContainersAndList;

import thinkjava.net.mindview.util.Print;

import java.util.*;

/**
 * Created by Jon on 2016/6/10.
 * 11.4 容器的打印
 */
public class PrintingContainers {
    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        Print.print(fill(new ArrayList<String>()));
        Print.print(fill(new LinkedList<String>()));
        Print.print(fill(new HashSet<String>()));
        Print.print(fill(new TreeSet<String>()));
        Print.print(fill(new LinkedHashSet<String>()));
        Print.print(fill(new HashSet<String>()));
        Print.print(fill(new TreeMap<String, String>()));
        Print.print(fill(new LinkedHashMap<String, String>()));
    }
}
