package JavaConcurrency.Exercise;

import net.mindview.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/29.
 */
public class Exercise_23 {
    public static void main(String[] args) throws Exception {
        Car2 car = new Car2();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(new WaxOff2(car));
        exec.submit(new WaxOn2(car));
        TimeUnit.SECONDS.sleep(5);   //Run for a while..
        exec.shutdownNow(); // Interrupt all tasks
    }
}

class Car2 {
    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;//Ready to buff
        notify();
    }

    public synchronized void buffed() {
        waxOn = false; //Ready for another coat of wax
        notify();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false)
            wait();
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true)
            wait();
    }
}

class WaxOn2 implements Runnable {
    private Car2 car;

    public WaxOn2(Car2 car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Print.printnb("Wax On !");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            Print.print("Exiting via interrupt");
        }
        Print.print("Ending Wax On task");
    }
}

class WaxOff2 implements Runnable {
    private Car2 car;

    public WaxOff2(Car2 car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.buffed();
                car.waitForWaxing();
                Print.printnb("Wax Off! ");
            }
        } catch (InterruptedException e) {
            Print.print("Exiting via interrupt");
        }
        Print.print("Ending Wax Off task");
    }
}