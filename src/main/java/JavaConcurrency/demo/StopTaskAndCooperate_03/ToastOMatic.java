package JavaConcurrency.demo.StopTaskAndCooperate_03;

import net.mindview.util.Print;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jon on 2016/6/5.
 * 21.5.4生产者消费者问题
 * <p>
 * <p>
 * !!!!!!!!!!!!!!!!看不懂
 * <p>
 * 吐司的 BlockingQueue
 *
 * 做Toast任务加入到toast队列，
 * Butterer去toastQueue队列取做好的toast，做好后加入到butterer队列，
 * Jammer从Queue队列取做好的butterer，做好后加入到JammerQueue
 */

class Toast {
    public enum Status {DRY, BUTTERED, JAMMED}

    private Status status = Status.DRY;
    private final int id;

    public Toast(int idn) {
        id = idn;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {
}

class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue tq) {
        toastQueue = tq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                //Make toast
                Toast t = new Toast(count++);
                Print.print(t);
                // Insert into queue
                toastQueue.put(t);
            }
        } catch (InterruptedException e) {
            Print.print("Toaster interrupted");
        }
    }
}

// Apply butter to toast:
class Butterer implements Runnable {
    private ToastQueue dryQueue, butteredQuue;

    public Butterer(ToastQueue dry, ToastQueue buttered) {
        this.dryQueue = dry;
        this.butteredQuue = buttered;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Blocks until net piece of toast is available:
                Toast t = dryQueue.take();
                t.butter();
                Print.print(t);
                butteredQuue.put(t);
            }
        } catch (InterruptedException e) {
            Print.print("Butterer off");
        }
    }
}

// Apply jam to buttered toast:
class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast t = butteredQueue.take();
                t.jam();
                Print.print(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            Print.print("Jammer interrupted");
        }
        Print.print("Jammer off");
    }
}

//Consume the toast :
class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Blocks until next piece of toast is available:
                Toast t = finishedQueue.take();
                //Verify that the toast is coming in order,
                //and that all pieces are getting jammed:
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
                    Print.print(">>>>> Error : " + t);
                    System.exit(1);
                } else
                    Print.print("Chomp! " + t);
            }
        } catch (InterruptedException e) {
            Print.print("Eater interrupted");
        }
        Print.print("Eater off");
    }
}

public class ToastOMatic {
    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}