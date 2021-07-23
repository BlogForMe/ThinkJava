package concurrency.lagou;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 停止线程
 */
public class ShutdownTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(new ShutDownThread());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdownNow();

    }

    static class ShutDownThread implements Runnable {
        static int taskId = 0;

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    Thread.sleep(5000);
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println("taskId Terminated" + taskId++);
            }
            System.out.println("");
        }
    }
}
