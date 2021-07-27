package concurrency.state;

public class WAITING_TIMEOUT {


    private static Thread threadA;

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        threadA = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " " + threadA.getState());
                try {
                    lock.wait(5000);
                } catch (InterruptedException e) {
                }
            }
        }, "Thread-A");
        threadA.start();
        Thread.sleep(2000L);
        System.out.println(Thread.currentThread().getName() + " 线程A的状态 " + threadA.getState());
    }

}


