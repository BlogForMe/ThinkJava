package thinkjava.JavaConcurrency.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 17-8-27.
 */
public class ConcurrencyInstance {

    private static ConcurrencyInstance cInstance;

    private ConcurrencyInstance() {
    }

    public static ConcurrencyInstance getInstance() {
        synchronized (ConcurrencyInstance.class) {
            if (cInstance == null)
                cInstance = new ConcurrencyInstance();
            return cInstance;
        }
    }

    public synchronized void tSynchronized1() {
        System.out.println("tSynchronized1");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void tSynchronized2() {
        System.out.println("tSynchronized2");
    }



}
