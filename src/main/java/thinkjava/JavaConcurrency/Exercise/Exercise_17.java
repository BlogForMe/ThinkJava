package thinkjava.JavaConcurrency.Exercise;

import thinkjava.net.mindview.util.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/28.
 * 抄的
 */


public class Exercise_17 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Sensor(i));
        TimeUnit.SECONDS.sleep(3);
        Sensor.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            Print.print("Some tasks were not terminated!");
        Print.print("Total : " + Sensor.getTotalCount());
        Print.print("Sum of Sensors: " + Sensor.sumSensors());

    }
}

class Count {
    private int count = 0;
    private Random rand = new Random(47);

    //Remove the synchronized keyword to see counting fail :
    public synchronized int incremnt() {
        int temp = count;
        if (rand.nextBoolean())
            Thread.yield();
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}

class Sensor implements Runnable {
    private static Random rand = new Random(47);
    private static Count count = new Count();
    private static List<Sensor> sensors = new ArrayList<Sensor>();
    private int number;
    private final int id;
    private static volatile boolean canceled = false;

    public static void cancel() {
        canceled = true;
    }

    public Sensor(int id) {
        this.id = id;
        sensors.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            //Simulate a random occurence of an ionizing event
            if (rand.nextInt(5) == 0) {
                synchronized (this) {
                    ++number;
                    count.incremnt();
                }
            }
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                Print.print("sleep interrupted");
            }
        }
    }

    public synchronized int getValue() {
        return number;
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumSensors() {
        int sum = 0;
        for (Sensor sensor : sensors)
            sum += sensor.getValue();
        return sum;
    }


    @Override
    public String toString() {
        return " Sensor " + id
                + ": " + getValue();
    }
}


