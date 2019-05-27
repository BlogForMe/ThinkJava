package JavaConcurrency.Exercise;

import net.mindview.util.Print;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/30.
 */
public class Exercise_30 {
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();

    }
}


class CharQueue extends LinkedBlockingDeque<Character> {
}

class Sender implements Runnable {
    private Random rand = new Random(47);
    private CharQueue out = new CharQueue();

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (char c = 'A'; c <= 'Z'; c++) {
                    out.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            Print.print(e + "Sender write exception");
        }
    }

    public CharQueue getOut() {
        return out;
    }
}

class Receiver implements Runnable {
    private Sender sender;

    public Receiver(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Print.print("Read:  " + (char) sender.getOut().take());
            }
        } catch (InterruptedException e) {
            Print.print(e + "Read interrupted");
//            e.printStackTrace();
        }
    }
}

