package thinkjava.JavaConcurrency.demo.StopTaskAndCooperate_03;

import thinkjava.net.mindview.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Jon on 2016/5/12.
 * Using Lock and Condition objects.
 * <p>
 * 就是打蜡和抛光循环
 * 现叫醒所有线程 ，打蜡后线程挂起，叫醒所有线程，抛光后挂起
 */

class Car2 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;

    /**
     * 打蜡
     */
    public void waxed() {
        lock.lock();
        try {
            waxOn = true;  //Ready to buff
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 抛光
     */
    public void buffed() {
        lock.lock();
        try {
            waxOn = false;  // Ready for another coat of wax
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == false)
                condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == true)
                condition.await();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 打蜡任务
 */
class WaxOn2 implements Runnable {
    private Car2 car;

    public WaxOn2(Car2 c) {
        this.car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Print.printnb("Wax On! ");
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

/**
 * 抛光任务
 */
class WaxOff2 implements Runnable {
    private Car2 car;

    public WaxOff2(Car2 c) {
        this.car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                Print.printnb("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            Print.print("Exiting via interrupt");
        }
        Print.print("Ending Wax Off task");
    }
}


public class WaxOMatic2 {
    public static void main(String[] args) throws Exception {
        Car2 car = new Car2();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff2(car));
        exec.execute(new WaxOn2(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
