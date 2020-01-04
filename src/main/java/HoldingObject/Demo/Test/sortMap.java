package HoldingObject.Demo.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/26.
 */
public class sortMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hMap = new LinkedHashMap<>();
        hMap.put(1, 1);
        hMap.put(4, 4);
        hMap.put(5, 5);
        hMap.put(3, 3);
        hMap.put(2, 2);
        Iterator<Map.Entry<Integer, Integer>> it = hMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println(e.getKey() + "  " + e.getValue());
        }

    }
}
