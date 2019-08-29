package JavaConcurrency.Exercise;

import net.mindview.util.Print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

/**
 * Created by jon on 16-12-29.
 */
class LiftOffRunner1 implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner1(BlockingQueue<LiftOff> queue) {
        this.rockets = queue;
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            Print.print("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();  // Use this thread
            }
        } catch (InterruptedException e) {
            Print.print("Waking from take");
        }
        Print.print("Exiting LiftOffRunner");
    }
}

class LiftOffProducer implements Runnable {
    LiftOffRunner1 liftOffRunner1;

    public LiftOffProducer(LiftOffRunner1 liftOffRunner1) {
        this.liftOffRunner1 = liftOffRunner1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            liftOffRunner1.add(new LiftOff(5));
    }
}

public class Exercise_28 {
    static void getkey() {
        try {
            //Compensate for Windows/Linux difference in the length of the result produced by the Enter key:
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getkey(String message) {
        Print.print(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        Print.print(msg);

        ExecutorService exec = Executors.newCachedThreadPool();
        LiftOffRunner1 runner = new LiftOffRunner1(queue);
//        Thread t = new Thread(runner);
//        t.start();
        LiftOffProducer liftOffProducer = new LiftOffProducer(runner);
        exec.execute(runner);
        exec.execute(liftOffProducer);
        getkey("Press 'Enter' (" + msg + ")");
        exec.shutdown();
        Print.print("Finished " + msg + " test");
    }

    public static void main(String[] args) {
//        test("LinkedBlockingQueue", new LinkedBlockingDeque<>());  //Unlimited size
//        test("ArraayBlockingQueue", new ArrayBlockingQueue<>(3));
//        test("SynchronousQueue<LiftOff>()", new SynchronousQueue<>());
    }
}