package HoldingObject.Demo.StackAndSetMap;

import net.mindview.util.Print;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Jon on 2016/6/11.
 * 11.9 Set
 */
public class SetOperations {
    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<String>();
        Collections.addAll(set1, "A,B,C,D,E,F,G,H,I,J,K,L".split(" "));
        set1.add("M");
        Print.print("H:" + set1.contains("H"));   //为啥是  false  !!!!!
        Print.print("N:" + set1.contains("N"));
        HashSet<String> set2 = new HashSet<String>();
        Collections.addAll(set2, "H  I J K L".split(" "));
        Print.print("set2 in  set1" + set1.containsAll(set2));



    }
}
