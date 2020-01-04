package JavaConcurrency.Exercise;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/29.
 */
public class Exercise_24 {
    public static void main(String[] args) throws Exception {
        int producerSleep = 20, consumerSleep = 20;
        FlowQueue<Item> fq = new FlowQueue<>(50);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Producer(fq, producerSleep));
        exec.execute(new Consumer(fq, consumerSleep));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

//A queue for solving flow-control probles.
class FlowQueue<T> {
    private Queue<T> queue = new LinkedList<T>();
    private int maxSize;

    public FlowQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void put(T v) throws InterruptedException {
        while (queue.size() >= maxSize)
            wait();
        queue.offer(v);
        maxSize++;
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (queue.isEmpty())
            wait();
        T returnVal = queue.poll();
        maxSize--;
        notifyAll();
        return returnVal;
    }

}

class Item {
    private static int counter;
    private int id = counter++;

    public String toString() {
        return "Item " + id;
    }
}

//Consumes any object
class Producer implements Runnable {
    private int delay;
    private FlowQueue<Item> output;

    public Producer(FlowQueue<Item> output, int delay) {
        this.delay = delay;
        this.output = output;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                output.put(new Item());
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

//Consumes any object
class Consumer implements Runnable {
    private int delay;
    private FlowQueue<?> input;

    public Consumer(FlowQueue<?> input, int delay) {
        this.delay = delay;
        this.input = input;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                System.out.println(input.get());
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
