package thinkjava.JavaConcurrency.Exercise;

import thinkjava.net.mindview.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-12-28.
 */
public class Exerciese_21 {
    public static void main(String[] args) {
        Runnable runnable1 = new Run1(),
                runnable2 = new Run2(runnable1);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(runnable1);
        exec.execute(runnable2);
        Thread.yield();
        exec.shutdown();
    }
}

class Run1 implements Runnable {
    public Run1() {
        Print.print("Constructed run1");
    }

    @Override
    public void run() {
        Print.print("Run1 going in to wait");
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Print.print("Run1 exited wait");
    }

}

class Run2 implements Runnable {
    Runnable otherTask;

    public Run2(Runnable otherTask) {
        this.otherTask = otherTask;
        Print.print("Constructed Run2");
    }

    @Override
    public void run() {
        Print.print("Run2 pausing 5 seconds");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ignore) {
        }
        Print.print("Run2 calling notifyAll");
        synchronized (otherTask) {
            otherTask.notifyAll();
        }
    }
}




