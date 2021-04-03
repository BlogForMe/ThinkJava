package jvm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    public static volatile AtomicInteger race = new AtomicInteger(0);

    public static void increase() {
//        race++;
        race.incrementAndGet();
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }

                }
            });
            threads[i].start();
        }
// 等待所有累加线程都结束
//        while (Thread.activeCount() > 1)
//            Thread.yield();

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(race);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");

    }

}
