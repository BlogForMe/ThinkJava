package JavaConcurrency.Exercise;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jon on 16-12-26.
 */
public class Exercise_06 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++)
            exec.submit(new Exercise_06().new SleepTask());
        exec.shutdown();
        int i = 0;
        while (i < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            System.out.println(i);

        }

    }


    class SleepTask implements Runnable {

        Random rand = new Random();
        int THREAD_SLEEP_TIME = (rand.nextInt(10) + 1) * 1000;

        @Override
        public void run() {

            try {
                Thread.sleep(THREAD_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(THREAD_SLEEP_TIME);

        }
    }


}
