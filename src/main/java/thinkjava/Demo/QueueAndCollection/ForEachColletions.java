package thinkjava.Demo.QueueAndCollection;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Jon on 2016/6/11.
 * 11.13 Foreach与迭代器
 * ALL collections work with foreach
 */
public class ForEachColletions {
    public static void main(String[] args) {
        LinkedList<String> cs = new LinkedList<String>();
        Collections.addAll(cs,"Take the long way home".split(" "));
        for (String s : cs)
            System.out.print("'" + s +" '");
    }
}
