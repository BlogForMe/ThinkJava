package JavaConcurrency.demo.deadlockingAndNewLiabrary_04;

import net.mindview.util.Print;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * Created by jon on 16-12-31.
 * 21.7.4 PriorityBlockingQueue
 * <p>
 * Comparator接口要实现的方法和书上不一样
 */

class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return priority < o.priority ? 1 : (priority > o.priority ? -1 : 0);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print(this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]", priority) + " Task  " + id;
    }

    public String summary() {
        return "(" + id + ":" + priority + " ) ";
    }

    public static class EndSeninel extends PrioritizedTask {
        private ExecutorService exec;

        public EndSeninel(ExecutorService e) {
            super(-1);  //Lowest priority in this program
            exec = e;
        }

        @Override
        public void run() {
            int count = 0;
            for (PrioritizedTask pt : sequence) {
                Print.printnb(pt.summary());
                if (++count % 5 == 0)
                    print();
            }
            print();
            print(this + "Calling shutdownNow");
            exec.shutdownNow();
        }
    }
}

class PrioritizedTaskProducer implements Runnable {
    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService exec) {
        this.queue = queue;
        this.exec = exec;  //Used for EndSentinel
    }

    @Override
    public void run() {
        //Unbounded queue; never blocks
        //Fill it up fast with random priorities;
        for (int i = 0; i < 20; i++)
            queue.add(new PrioritizedTask(rand.nextInt(10)));
        Thread.yield();
        //Trickle in highest
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            //Add jobs, lowest priority first
            for (int i = 0; i < 10; i++)
                queue.add(new PrioritizedTask(i));
            //A sentinel to stop all tasks;
            queue.add(new PrioritizedTask.EndSeninel(exec));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Finished PrioritizedTaskProducer");

    }
}

class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (!Thread.interrupted())
            //Use current thread
            try {
                q.take().run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        print("Finished prioritizedTaskConsumer");
    }
}

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        exec.execute(new PrioritizedTaskProducer(queue, exec));
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}
