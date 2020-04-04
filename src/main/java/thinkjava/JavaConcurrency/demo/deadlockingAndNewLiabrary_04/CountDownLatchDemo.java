package thinkjava.JavaConcurrency.demo.deadlockingAndNewLiabrary_04;

import thinkjava.net.mindview.util.Print;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jon on 2016/6/6.
 * 21.7新类库中的构件
 * CountDownLatch
 * 从运行结果可以看到，CountDownLatch初始计数是SIZE=100,一个线程运行完调用countDown(),直到降到完成，
 * 就开始执行await（）所在线程的任务，阻塞的任务
 */

//Performs some portion of a  task:
class TaskPortion implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException ex) {
            //Acceptable way to exit
        }
    }


    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        Print.print(this + "  completed   " + latch.getCount());
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}

//Waits on the CountDownLatch:
class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();  //等待latch.countDown()计数完成
            Print.print("Latch barrier passed for" + this);
        } catch (InterruptedException ex) {
            Print.print(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask 5$-3d ", id);
    }
}

public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        //All must share a singel CounDownLatch object:
        CountDownLatch latch = new CountDownLatch(SIZE);
//        for (int i = 0; i < 10; i++)
            exec.execute(new WaitingTask(latch));
        for (int i = 0; i < SIZE; i++)
            exec.execute(new TaskPortion(latch));
        Print.print("Launched all tasks");
        exec.shutdown();   // Quit wehen all tasks complete
    }
}
