package concurrency.state;

import java.util.concurrent.TimeUnit;

public class NOTIFY {


    private static Thread threadA;

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
         threadA = new Thread(() -> {
            synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " " + threadA.getState());
                try {
                   lock.wait();
                } catch (InterruptedException e) {}
                System.out.println(Thread.currentThread().getName() + " 线程A的状态 " + threadA.getState());
            }
        }, "Thread-A");
        threadA.start();
        Thread.sleep(2000L);
        System.out.println(Thread.currentThread().getName() + " 线程A的状态 " + threadA.getState());

    }

}


