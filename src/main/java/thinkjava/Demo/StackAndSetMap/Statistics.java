package thinkjava.Demo.StackAndSetMap;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Jon on 2016/6/11.
 * 11.10 Map
 */
public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i=0;i<10000;i++){
            //Produce a number between 0  and 20;
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r,freq ==null? 1 : freq+1);
        }
        System.out.println(m);
    }
}
