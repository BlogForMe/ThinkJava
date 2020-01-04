package JavaConcurrency.Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestThreadInterrupt {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        TestThread testThread = new TestThread();
        Future<?> futre = exec.submit(testThread);
//        testThread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        futre.cancel(true);
//        testThread.interrupt();


    }

    static class TestThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
                System.out.println(new Date() + "   " + isInterrupted());
            }
        }
    }

}
