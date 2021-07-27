package concurrency.lock;

import java.util.concurrent.TimeUnit;

/**
 * 可重入锁
 */
// 结果为何为 0
public class ReEnterLock implements Runnable {
    static synchronized_01 instance = new synchronized_01();
    static int i = 0;
    static int j = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {

            //this,当前实例对象锁
            synchronized (this) {
                i++;
                increase();//synchronized的可重入性
            }
        }
    }

    public synchronized void increase() {
        j++;
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(i);
        System.out.println(j);

    }
}
