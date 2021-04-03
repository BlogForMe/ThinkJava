package jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JMV_TEST {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("hello", "你好");
//        map.put("how are you?", "吃了没?");
//        System.out.println(map.get("hello"));
//        System.out.println(map.get("how are you?"));
        ArrayList<Integer> ilist = new ArrayList<Integer>();
        ArrayList<Long> llist = new ArrayList<Long>();
        ArrayList list;
        list = ilist;
        list = llist;

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;

        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

    }


//    public static String method(List<String> list) {
//        System.out.println("invoke method(List<String> list)");
//        return "";
//    }
//    public static int method(List<Integer> list) {
//        System.out.println("invoke method(List<Integer> list)");
//        return 1;
//    }

}
