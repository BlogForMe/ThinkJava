package thinkjava.JavaConcurrency.queue;

import java.util.Deque;
import java.util.concurrent.*;

public class ConsumerProducer {
    private static final String EXIT_MSG = "Good bye!";

    public static void main(String[] args) {
        // 使用较小的队列，以更好地在输出中展示其影响
        Deque<String> queue = new ConcurrentLinkedDeque();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    static class Producer implements Runnable {
        private Deque<String> queue;

        Producer(Deque<String> q) {
            this.queue = q;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(6L);
                    String msg = "Message" + i;
                    System.out.println("Produced new item: " + msg);
                    queue.add(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Time to say good bye!");
            queue.add(EXIT_MSG);
        }
    }

    static class Consumer implements Runnable {
        private Deque<String> queue;

        Consumer(Deque<String> q) {
            this.queue = q;
        }

        @Override
        public void run() {
            try {
                String msg;
                while (!EXIT_MSG.equalsIgnoreCase((msg = queue.pollFirst()))) {
                    System.out.println("Consumed item: " + msg);
                    Thread.sleep(5);
                }
                System.out.println("Got exit message, bye!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


