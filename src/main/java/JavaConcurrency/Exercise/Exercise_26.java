package JavaConcurrency.Exercise;

import net.mindview.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/29.
 */
public class Exercise_26 {

    public static void main(String[] args) {
        new Restaurant2();
    }
}

class Restaurant2 {
    Meal2 meal = null;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson2 waitPerson = new WaitPerson2(this);
    BusBoy busBoy = new BusBoy(this);
    Chef2 chef = new Chef2(this);

    public Restaurant2() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busBoy);
    }
}


class Meal2 {
    private final int orderNum;

    public Meal2(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}

class BusBoy implements Runnable {
    private Restaurant2 restaurant;
    boolean notified;
    volatile Meal2 meal;

    public BusBoy(Restaurant2 restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    if (!notified)
                        wait(); // ... for meal delivery
                    notified = false;
                }
                Print.print("Busboy cleaned up " + meal);
                synchronized (restaurant.waitPerson) {
                    restaurant.waitPerson.notified = true;
                    restaurant.waitPerson.notifyAll();
                }
            }
        } catch (InterruptedException e) {

        }
    }
}


class WaitPerson2 implements Runnable {
    private Restaurant2 restaurant;
    boolean notified;

    public WaitPerson2(Restaurant2 r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null)
                        wait(); // ... for the chef to produce a meal
                    Print.print("WaitPerson wait");
                }
                synchronized (restaurant.busBoy) {
                    restaurant.busBoy.notified = true;
                    restaurant.busBoy.meal = restaurant.meal;
                    restaurant.busBoy.notifyAll();//Clean up

                }

                Print.print("Waitperson got" + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); //Ready for another
                }
            }
        } catch (InterruptedException e) {
            Print.print("WaitPerson interrupted");
        }

    }
}

class Chef2 implements Runnable {
    private Restaurant2 restaurant;
    private int count = 0;

    public Chef2(Restaurant2 r) {
        this.restaurant = r;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait(); //... for the meal to be taken
                    Print.print("Chef wait...");
                }
                if (++count == 10) {
                    Print.print("Out of food, closing");
                    restaurant.exec.shutdownNow();
                    return;   // Exercise_25  添加这个查看结果
                }
                Print.printnb("Order up    ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal2(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            Print.print("Chef interrupted");
        }
    }
}