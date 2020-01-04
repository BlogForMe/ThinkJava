package JavaConcurrency.demo.ShareResources_02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jon on 16-4-16.
 * 显示lock
 * <p>
 * locks in the concurrent library allow you
 * to give up on trying to acquire alock
 *
 *
 * 这个获取锁的过程还是不理解
 *
 * 对象没有足够的时间获取锁，休眠一段时间就可以了
 *
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("trylock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();

        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
//                super.run();
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();

        Thread.yield();
        try {
            TimeUnit.SECONDS.sleep(2);  // 这样有足够的时间给对象加锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        al.untimed();
        al.timed();

    }

}
