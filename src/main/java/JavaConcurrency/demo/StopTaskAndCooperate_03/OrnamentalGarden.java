package JavaConcurrency.demo.StopTaskAndCooperate_03;

import net.mindview.util.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jon on 2016/5/3.
 * 21.4.1  装饰性花园
 *
 * 疑问：为什么每个门都是 30个
 * 疑问解答，每个都是30个是因为睡了100ms,如果没这个就不确定了
 *
 */
class Count {
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

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    //Doesn't need synchronization to read
    private final int id;
    private static volatile boolean canceled = false;

    //Atomic operation on  a  volatile field:
    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        //Keep this task in a  list. Also prevents
        //garbage  collection of dead tasks:
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            Print.print(this + "   Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                Print.print("sleep interrupt");
            }
        }
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
        for (Entrance entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }
}


public class OrnamentalGarden {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Entrance(i));
        //Run for a while. then stop and collect the data:
        try {
            TimeUnit.SECONDS.sleep(3);
            Entrance.cancel();
            exec.shutdown();
//            if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
//                Print.print("Some tasks were not terminated!");
            Print.print("Total: " + Entrance.getTotalCount());
            Print.print("Sum of Entances: " + Entrance.sumEntrances());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
