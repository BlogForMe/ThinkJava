package concurrency.pool.blockqueue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        boolean offer = queue.offer(1);
        System.out.println(offer);

    }
}
