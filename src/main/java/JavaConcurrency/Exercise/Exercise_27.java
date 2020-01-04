package JavaConcurrency.Exercise;

import net.mindview.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jon on 16-12-29.
 */
public class Exercise_27 {
    public static void main(String[] args) {
        new Restaurant3();
    }
}

class Meal3 {
    private final int orderNum;

    public Meal3(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}

class WaitPerson3 implements Runnable {
    private Restaurant3 restaurant;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public WaitPerson3(Restaurant3 r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant.meal == null)
                        condition.await(); // ... for the chef to produce a meal
                    Print.print("WaitPerson wait");
                } finally {
                    lock.unlock();
                }

                Print.print("Waitperson got" + restaurant.meal);
                restaurant.chef.lock.lock();
                try {
                    restaurant.meal = null;
                    restaurant.chef.condition.signalAll(); //Ready for another
                } finally {
                    restaurant.chef.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            Print.print("WaitPerson interrupted");
        }

    }
}

class Chef3 implements Runnable {
    private Restaurant3 restaurant;
    private int count = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public Chef3(Restaurant3 r) {
        this.restaurant = r;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant.meal != null)
                        condition.await(); //... for the meal to be taken
                    Print.print("Chef wait...");
                } finally {
                    lock.unlock();
                }

                if (++count == 10) {
                    Print.print("Out of food, closing");
                    restaurant.exec.shutdownNow();
                    return;   // Exercise_25  添加这个查看结果
                }
                Print.printnb("Order up    ");
                restaurant.waitPerson.lock.lock();
                try {
                    restaurant.meal = new Meal3(count);
                    restaurant.waitPerson.condition.signalAll();
                } finally {
                    restaurant.waitPerson.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            Print.print("Chef interrupted");
        }


    }
}

class Restaurant3 {
    Meal3 meal = null;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson3 waitPerson = new WaitPerson3(this);
    Chef3 chef = new Chef3(this);

    public Restaurant3() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }
}