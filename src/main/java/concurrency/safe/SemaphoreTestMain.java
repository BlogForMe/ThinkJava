package concurrency.safe;

import java.util.concurrent.Semaphore;

public class SemaphoreTestMain {

    static Semaphore sSemaphore = new Semaphore(6);

    public static void main(String[] args) {
        final SemaphoreTestMain semaphoreTestMain = new SemaphoreTestMain();
        for (int i = 0; i < 1000; i++) {
            Thread myThread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        semaphoreTestMain.test();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            myThread.setName("threat index:" + i);
            myThread.start();
        }
    }


    public void test() throws InterruptedException {
        sSemaphore.acquire();
        System.out.println(Thread.currentThread().getName() + "--in");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "--out");
        sSemaphore.release();

    }

}
