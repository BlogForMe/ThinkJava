package thinkjava.JavaConcurrency.demo.deadlockingAndNewLiabrary_04;

import thinkjava.net.mindview.util.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static thinkjava.net.mindview.util.Print.print;

/**
 * Created by jon on 16-12-31.
 * 21.7.3  DelayQueue
 * 把延迟时间最短的先执行
 */

public class DelayQueueDemo {
    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        //Fill with tasks that hava random delays;
        for (int i = 0; i < 20; i++)
            queue.put(new DelayedTask(rand.nextInt(5000)));

//        //Set the stopping point
//        queue.add(new DelayedTask.EndSentinel(5000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}


class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    private static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int delayInMilliSecodn) {
        this.delta = delayInMilliSecodn;
        trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS); //先把延迟的时间转化成纳秒，再加上系统时间
        sequence.add(this);
    }

    /**
     * 获取延迟时间
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask) arg;
        if (trigger < that.trigger) return -1;
        if (trigger > that.trigger) return 1;
        return 0;
    }

    @Override
    public void run() {
        Print.printnb(this + "  ");
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]", delta) + " Task " + id;
    }

    public String summary() {
        return "(" + id + ";" + delta + ")";
    }

    public static class EndSentinel extends DelayedTask {
        private ExecutorService exec;

        public EndSentinel(int delayInMilliSecodn, ExecutorService exec) {
            super(delayInMilliSecodn);
            this.exec = exec;
        }

        @Override
        public void run() {
            for (DelayedTask pt : sequence)
                Print.printnb(pt.summary() + " ");
            print();
            print(this + " Calling shutdownNow");
            exec.shutdownNow();
        }

    }

}


class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                q.take().run();//Run task with the current the thread
        } catch (InterruptedException e) {
            //Acceptable way to exit
        }
        print("finished DelayedTaskConsumer");
    }
}

