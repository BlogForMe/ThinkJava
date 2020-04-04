package thinkjava.JavaConcurrency.demo.StopTaskAndCooperate_03;

import thinkjava.net.mindview.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jon on 16-12-28.
 *
 * 这里面不理解　它的流程
 *
 */

class Car {
    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;//Ready to buff
        System.out.println("waxed()");
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false; //Ready for another coat of wax
        System.out.println("buffed()");
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        System.out.println("waitForWaxing()");
        while (waxOn == false)
            wait();
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        System.out.println("waitForBuffing()");
        while (waxOn == true)
            wait();
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Print.printnb("Wax On !");
                TimeUnit.MILLISECONDS.sleep(2000);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            Print.print("Exiting via interrupt");
        }
        Print.print("Ending Wax On task");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
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

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(new WaxOff(car));
        exec.submit(new WaxOn(car));
        TimeUnit.SECONDS.sleep(10);   //Run for a while..
        exec.shutdownNow(); // Interrupt all tasks
    }
}