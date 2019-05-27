package JavaConcurrency.demo.BasicThreadSyntax_01;

import net.mindview.util.Print;

import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-4-14.
 * 可以通过调用isDaemon()确定线程是否是一个后台线程
 */
class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            Print.printnb("DemonSpawn" + i + "start,");
        }
        for (int i=0;i<t.length;i++)
            if (i%5==0)
            Print.print("t[" + i +"].isDaemon()" +t[i].isDaemon()+",");
            else
            Print.printnb("t[" + i +"].isDaemon()" +t[i].isDaemon()+",");
        while (true)
            Thread.yield();

    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}

public class Daemons {
    public static void main(String[] args) throws  Exception{
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();

        Print.print("d.isDaemon()=" +d.isDaemon() +"  ,");
        TimeUnit.SECONDS.sleep(1);

    }
}
