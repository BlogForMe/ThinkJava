package JavaConcurrency.Exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/12/28.
 */
public class Exercise_20 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff2());
        exec.shutdownNow();
    }
}


class LiftOff2 implements Runnable {
    protected int countDown = 10;
    private static int tasKCount = 0;
    private final int id = tasKCount++;

    public LiftOff2() {
    }

    public LiftOff2(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "liftoff!") + ").";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("interrupt()");
                return;
            }
            System.out.print(status());
            Thread.yield();
        }
    }


}