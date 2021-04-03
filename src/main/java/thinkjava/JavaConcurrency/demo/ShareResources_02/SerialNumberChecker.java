package thinkjava.JavaConcurrency.demo.ShareResources_02;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public synchronized static int nextSerialNuber() {
        return serialNumber++;  //Not thread safe
    }
}


/**
 * Created by Jon on 2016/5/1.
 * Operations that may seem safe are not
 * when threads are present
 */
//Reuses  storage so we don't  run out of jmm;
class CircularSet {
    private final int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        len = size;
        //Initialize to a  value not produced  by the SerialNumberGenerator
        for (int i = 0; i < size; i++)
            array[i] = -1;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++)
            if (array[i] == val)
                return true;
        return false;
    }

    public synchronized void add(int i) {
        array[index] = i;
        //Wrap index and write over old elements
        index = ++index % len;
    }
}

public class SerialNumberChecker {
    private static final int SIZE = 10;

    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChcker implements Runnable {
        @Override
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNuber();
                System.out.println(serial);
                if (serials.contains(serial)) {   //验证array数组里
                    System.out.println("Doplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++)
            exec.execute(new SerialChcker());
        exec.shutdown();

        //Stop after n seconds if there's an argument:
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }

    }

}
