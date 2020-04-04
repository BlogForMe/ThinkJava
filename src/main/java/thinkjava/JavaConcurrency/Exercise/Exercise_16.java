package thinkjava.JavaConcurrency.Exercise;

import thinkjava.net.mindview.util.Print;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/12/27.
 */
public class Exercise_16 {
    public static void main(String[] args) {
        SyncExercise2 ds = new SyncExercise2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ds.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ds.b();
            }
        }).start();
        ds.c();

    }
}

class SyncExercise2 {
    ReentrantLock aLock = new ReentrantLock();
//    ReentrantLock bLock = new ReentrantLock();
//    ReentrantLock cLock = new ReentrantLock();

    public void a() {
        aLock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                Print.print("a()");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            aLock.unlock();
        }

    }

    public void b() {
        aLock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                Print.print("b()");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            aLock.unlock();
        }
    }

    public void c() {
        aLock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                Print.print("c()");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            aLock.unlock();
        }
    }
}

