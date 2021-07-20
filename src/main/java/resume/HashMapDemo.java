package resume;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap map = new HashMap<HashMapDemo,Integer>(1);
        for (int i = 0; i < 1000; i++) {
            HashMapDemo hashMapDemo1 = new HashMapDemo();
            map.put(hashMapDemo1, null);
        }

        Object show = map.entrySet().toArray()[0];

        System.out.println("运行结束");

        HashMapDemo demo1 = new HashMapDemo();
        HashMapDemo demo2 = new HashMapDemo();

        System.out.println(demo1);
        System.out.println(demo2);

        System.out.println(demo1.equals(demo2));
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
