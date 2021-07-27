package concurrency.state;

public class WaitJOIN {


    private static Thread threadA;
    private static Thread threadB;

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        threadA = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " " + threadA.getState());
                    threadB.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-A");

        threadB = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " " + threadB.getState());
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-B");

        threadA.start();
        threadB.start();

        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "运行 线程A的状态 " + threadA.getState());

    }
}


