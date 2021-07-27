package concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * https://juejin.cn/post/6844903983308341261
 * 公平锁
 */
public class ReentrantLockTest {
    private static final int COUNT = 100;
    private static int start = 1;
    static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Runnable task = () -> {
            for (; ; ) {
                lock.lock();
                try {
                    if (start <= COUNT) {
                        System.out.println(Thread.currentThread().getName() + "=> " + start++);
                    } else {
                        System.exit(0);
                    }
                } finally {
                    lock.unlock();
                }
            }
        };
        new Thread(task).start();
        new Thread(task).start();
    }

}
