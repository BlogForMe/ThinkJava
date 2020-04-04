package thinkjava.JavaConcurrency.demo.StopTaskAndCooperate_03;

import thinkjava.net.mindview.util.Print;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/12/28.
 * 没有发生中断
 */
public class Interrupting2 {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Issuing t.interrupt()");
        t.isInterrupted();
    }
}


class BlockedMutex {
    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        //Acquire it right away, to demonstrate interruption
        // of a task blocked on a  ReentrantLock;
        lock.lock();
    }

    public void f() {
        try {
            //This will never be available to a second task
            lock.lockInterruptibly();  //Special call
            Print.print("lock acquired in f()");
        } catch (InterruptedException e) {
            Print.print("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable {
    BlockedMutex blocked = new BlockedMutex();

    @Override
    public void run() {
        Print.print("Waiting for f()  in BlockedMutex");
        blocked.f();
        Print.print("Broken out of blocked call");
    }
}


