package JavaConcurrency.Exercise;

import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-12-26.
 */
public class Exercise_08 {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new LiftOff(100));
            thread.setDaemon(true);
            thread.start();
        }
        TimeUnit.MILLISECONDS.sleep(1);
    }
}


class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int tasKCount = 0;
    private final int id = tasKCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "liftoff!") + ").";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}