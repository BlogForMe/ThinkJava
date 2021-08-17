package algorlthm.learn.lagou;

import java.util.Iterator;
import java.util.LinkedList;

public class Gongjin06 {
    public static void main(String[] args) {

        ring(10, 5);

    }

    public static void ring(int n, int m) {

        LinkedList<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) {

            q.add(i);

        }

        int k = 2;

        int element = 0;

        int i = 1;

        for (; i<k; i++) {  //从第k个人开始的

            element = q.poll();

            q.add(element);

        }
        Iterator<Integer> iter = q.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next());
        }
        System.out.println();
        i = 1;

        while (q.size() > 0) {

            element = q.poll();

            if (i < m) {

                q.add(element);

                i++;

            } else {

                i = 1;

                System.out.print(element);

            }

        }

    }

}
