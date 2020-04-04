package thinkjava.JavaConcurrency.demo.StopTaskAndCooperate_03;

import thinkjava.net.mindview.util.Print;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/28.
 * 21.4.4  检查中断
 */
public class InterruptingIdiom {
    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            Print.print("usage: java InterruptingIdiom delay-in-ms");
//            System.exit(1);
//        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(3);
        t.interrupt();
    }
}

class NeedsClenup {
    private final int id;

    public NeedsClenup(int id) {
        this.id = id;
        Print.print("NeedsCleanup " + id);
    }

    public void cleanup() {
        Print.print("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //point1
                NeedsClenup n1 = new NeedsClenup(1);
                //Start try-finally immediately after definition
                // of n1. to guarantee proper cleanup of n1:
                try {
                    Print.print("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    //point2
                    NeedsClenup n2 = new NeedsClenup(2);
                    //Guarantee proper cleanup of n2:
                    try {
                        Print.print("Calulating");
                        //A time-consuming. operation:
                        for (int i = 1; i < 2500000; i++)
                            d = d + (Math.PI + Math.E) / d;
                        Print.print("Finished time-consuming operation");
                    } finally {
                        n2.cleanup();
                    }

                } finally {
                    n1.cleanup();
                }
            }
            Print.print("Exiting via while() thinkjava.test");
        } catch (InterruptedException e) {
            Print.print("Exiting via InterruptedException");
        }
    }
}