package JavaConcurrency.demo.deadlockingAndNewLiabrary_04;

import net.mindview.util.Print;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jon on 2016/6/6.
 * 21.6 死锁
 */
public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.id = id;
        this.ponderFactor = ponderFactor;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Print.print(this + " " + "thinking");
                pause();
                //Philosopher becomes hungry
                Print.print(this + "  " + "grabbing right   " +(id+1));
                right.take();
                if (id==2){
                    System.out.println(right.taken);
                }
                pause();
                Print.print(this + " ." + "grabbing left     " + (id));
                left.take();
                Print.print(this + " " + "eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            Print.print(this + " " + "exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosopher" + id;
    }
}
