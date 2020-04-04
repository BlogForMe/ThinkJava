package thinkjava.JavaConcurrency.demo.ShareResources_02;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jon on 2016/5/1.
 * 21.3.4  原子类 使用原子类可以消除 synchronized
 */
public class AtomicIntergerTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);

    public int getValue() {
        return i.get();
    }

    public void evenIncrement() {
        i.addAndGet(2);
    }

    @Override
    public void run() {
       evenIncrement();
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);  //Terminate after 5  seconds
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntergerTest ait = new AtomicIntergerTest();
        exec.execute(ait);
        while (true) {
            int val = ait.getValue();
//            System.out.println(val);
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }

    }
}
