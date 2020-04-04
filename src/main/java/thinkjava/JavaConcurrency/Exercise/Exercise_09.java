package thinkjava.JavaConcurrency.Exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by jon on 16-12-26.
 */
public class Exercise_09 {
    public static void main(String[] args) {
        ExecutorService exec1 = Executors.newCachedThreadPool(new CustomThreadFactory(Thread.MIN_PRIORITY));
        for (int i = 0; i < 5; i++)
            exec1.submit(new SimplePriorities());

        Executors.newCachedThreadPool(new CustomThreadFactory(Thread.MAX_PRIORITY));
    }
}

class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d; //No optimization

    @Override
    public void run() {
        for (; ; ) {
            for (int i = 1; i < 10000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }
}


class CustomThreadFactory implements ThreadFactory {
    private int PRIORITIES;

    public CustomThreadFactory(int PRIORITIES) {
        this.PRIORITIES = PRIORITIES;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        return t;
    }
}