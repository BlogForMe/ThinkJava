package HoldingObject.Demo.QueueAndCollection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Jon on 2016/6/11.
 * 11.11 Queue
 */
public class QueueDemo {
    public static void printQ(Queue queue) {
        while (queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++)
            queue.offer(rand.nextInt(i + 10));
        printQ(queue);
        LinkedList<Character> qc = new LinkedList<>();
        for (char c : "Brontosaurus".toCharArray())
            qc.offer(c);
        printQ(qc);
    }
}
