package thinkjava.JavaConcurrency.demo.StopTaskAndCooperate_03;

import thinkjava.JavaConcurrency.demo.BasicThreadSyntax_01.LiftOff;
import thinkjava.net.mindview.util.Print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Jon on 2016/5/12.
 * 21.5.4生产者-消费者与队列
 */

class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
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

public class TestBlockingQueues {
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
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++)
            runner.add(new LiftOff(5));
        getkey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        Print.print("Finished " + msg + "thinkjava/test");
    }

    public static void main(String[] args) {
//        thinkjava.test("LinkedBlockingQueue", new LinkedBlockingDeque<>());  //Unlimited size
//        thinkjava.test("ArraayBlockingQueue", new ArrayBlockingQueue<>(3));
        test("SynchronousQueue<LiftOff>()", new SynchronousQueue<>());
    }
}
