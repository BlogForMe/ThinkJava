package JavaConcurrency.demo.BasicThreadSyntax_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-4-14.
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        super.run();
        while (countDown-- > 0) {
            System.out.println(status());
            try {
                Thread.sleep(100);
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }
}
