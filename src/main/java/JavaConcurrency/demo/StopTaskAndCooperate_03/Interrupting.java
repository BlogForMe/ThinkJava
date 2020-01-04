package JavaConcurrency.demo.StopTaskAndCooperate_03;

import net.mindview.util.Print;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/28.
 * 24.4.3  中断
 */
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        Print.print("Interrupting " + r.getClass().getName());
        f.cancel(true);  //Interrupts if running
        Print.print("Interrupt sen to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
//        test(new SleepBlocked());
//        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
//        TimeUnit.SECONDS.sleep(3);
        Print.print("Aborting with System.exit(0)");
//        System.exit(0); //
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) {
            //Nerver releases lock
            Thread.yield();
            System.out.println("f()");
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f();  //Lock acquired by  this thread
            }
        }.start();
    }

    @Override
    public void run() {
        Print.print("Trying to call f()");
        f();
        Print.print("Exiting SynchronizedBlocked.run()");
    }
}


class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5000);
        } catch (InterruptedException e) {
            Print.print("InterruptedException");
        }
        Print.print("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            Print.print("Wating for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                Print.print("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        Print.print("Exiting IOBlocked.run()");
    }
}


