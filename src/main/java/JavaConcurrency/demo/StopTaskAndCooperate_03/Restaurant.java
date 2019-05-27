package JavaConcurrency.demo.StopTaskAndCooperate_03;

import net.mindview.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jon on 2016/5/11.
 * 21.5.3生产者与消费者
 * <p>
 * The producer-consumer approach to  task cooperation.
 * 没有想要的结果
 */

class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant r) {
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

class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant r) {
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
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            Print.print("Chef interrupted");
        }


    }
}

public class Restaurant {
    Meal meal = null;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
