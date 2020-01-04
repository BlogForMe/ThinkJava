package JavaConcurrency.Exercise;

import net.mindview.util.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/28.
 * 疑问：不知道啥意思  没有调用Interrupt()方法
 */
public class Exercise_19 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Entrance1(i));
        //Run for a while. then stop and collect the data:
        try {
            TimeUnit.SECONDS.sleep(3);
//            Entrance1.cancel();

            exec.shutdown();
            if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
                Print.print("Some tasks were not terminated!");
            Print.print("Total: " + Entrance1.getTotalCount());
            Print.print("Sum of Entances: " + Entrance1.sumEntrances());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Count1 {
    private int count = 0;
    private Random rand = new Random(47);

    //Remove the synchronized keyword to see counting fail:
    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean())  //Yield half the time
            Thread.yield();
        return (count = ++temp);
    }

    public synchronized int value() {

        return count;
    }
}

class Entrance1 implements Runnable {
    private static Count1 count = new Count1();
    private static List<Entrance1> entrances = new ArrayList<>();
    private int number = 0;
    //Doesn't need synchronization to read
    private final int id;
//    private static volatile boolean canceled = false;

    //Atomic operation on  a  volatile field:
//    public static void cancel() {
//        canceled = true;
//    }

    public Entrance1(int id) {
        this.id = id;
        //Keep this task in a  list. Also prevents
        //garbage  collection of dead tasks:
        entrances.add(this);
    }

    @Override
    public void run() {
//        while (!canceled) {
        synchronized (this) {
            ++number;
        }
        Print.print(this + "   Total: " + count.increment());
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Print.print("sleep interrupt");
        }
//        }
        Print.print("Stopping" + this);
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Entrance " + id + ":" + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance1 entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }
}

