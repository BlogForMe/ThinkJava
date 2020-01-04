package JavaConcurrency.demo.deadlockingAndNewLiabrary_04;

/**
 * Created by Jon on 2016/6/6.
 * 21.6 死锁筷子
 * Chopsticks for dining philosophers
 */
public class Chopstick {
    protected boolean taken = false;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;


    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
