package JavaConcurrency.demo.demo_03;

import net.mindview.util.Print;

import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-4-15.
 */

class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            Print.print("Starting ADaemon");
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            Print.print("Exiting via InterrupterException");
        } finally {
            Print.print("This should always run?");
        }
    }
}

public class DaemonsDonRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
//        t.setDaemon(true);
        t.start();

    }
}
