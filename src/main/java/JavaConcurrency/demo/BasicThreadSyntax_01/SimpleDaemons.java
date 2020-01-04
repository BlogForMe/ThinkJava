package JavaConcurrency.demo.BasicThreadSyntax_01;

import net.mindview.util.Print;

import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-4-14.
 * 21.2.8后台线程
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                Print.print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            Print.print("Sleep() interrupted");
        }
    }

    public static void main(String[] args)throws  Exception {
        for(int i=0;i<10;i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        Print.print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(200);
    }
}
