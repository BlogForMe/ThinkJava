package concurrency.state;

public class WaitState {


    private static Thread threadA;
    private static Thread threadB;

    public static void main(String[] args) {
        final Object lock = new Object();
         threadA = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " " + threadA.getState());
                    lock.wait();
                    Thread.sleep(5000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BLOCKED-Thread-A");

         threadB = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " " + threadB.getState());
                System.out.println(Thread.currentThread().getName() + " 线程A的状态 " + threadA.getState());
                try {
                    Thread.sleep(5000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BLOCKED-Thread-B");

        threadA.start();
        threadB.start();
    }

}


//                System.out.println(Thread.currentThread().getName() + "  before wait() " + threadA.getState() );
