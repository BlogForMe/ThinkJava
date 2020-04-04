package thinkjava.JavaConcurrency.demo.deadlockingAndNewLiabrary_04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jon on 2016/6/6.
 * Demonstrates how deadlock can be hidden in  a  program
 *
 * 死锁问题没怎么弄明白，先放一放
 */
public class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        int ponder = 2, size = 3;
//        if (args.length > 0)
//            ponder = Integer.parseInt(args[0]);
//        int size = 5;
//        if (args.length > 1)
//            size = Integer.parseInt(args[1]);

        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++)
            sticks[i] = new Chopstick();
        for (int i = 0; i < size; i++)
            if (i < (size-1 ))
                exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
            else
                exec.execute(new Philosopher(sticks[0], sticks[i], i, ponder));
        TimeUnit.SECONDS.sleep(5);

        exec.shutdownNow();
    }
}
