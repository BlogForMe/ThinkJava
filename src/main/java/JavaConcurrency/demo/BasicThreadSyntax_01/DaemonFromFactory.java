package JavaConcurrency.demo.BasicThreadSyntax_01;

import net.mindview.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-4-14.
 */
class DaemonThreadFacotry implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}


public class DaemonFromFactory implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                Print.print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFacotry());
        for (int i = 0; i < 10; i++)
            exec.execute(new DaemonFromFactory());

        Print.print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);

    }
}
