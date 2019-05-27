package JavaConcurrency.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/12/30.
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        DynchronizedCounter dc = new DynchronizedCounter();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new TestRunnabel1(dc));
        exec.execute(new TestRunnabel2(dc));
        exec.shutdown();
    }
}

class TestRunnabel1 implements Runnable {
    private DynchronizedCounter dc;

    public TestRunnabel1(DynchronizedCounter dc) {
        this.dc = dc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            dc.incremnt();
    }
}


class TestRunnabel2 implements Runnable {
    private DynchronizedCounter dc;

    public TestRunnabel2(DynchronizedCounter dc) {
        this.dc = dc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            dc.decrement();
    }
}


class DynchronizedCounter {
    private int c = 0;

    public synchronized void incremnt() {
        c++;
        System.out.print("  " + c);
    }

    public synchronized void decrement() {
        c--;
        System.out.print("  " + c);
    }
}


