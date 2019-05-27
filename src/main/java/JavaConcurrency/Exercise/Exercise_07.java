package JavaConcurrency.Exercise;

import net.mindview.util.Print;

import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-12-26.
 */
public class Exercise_07 {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        Print.printnb("d.isDaemon() = " + d.isDaemon() + ", ");
        //Allow the daemon threads to finish their startup processes:
        TimeUnit.SECONDS.sleep(6);
    }

}

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            Print.printnb("DaemonSpawn " + i + " started,");
        }
        for (int i = 0; i < t.length; i++)
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
        while (true)
            Thread.yield();
    }
}

class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}
