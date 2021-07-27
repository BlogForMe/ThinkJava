package concurrency.state;

public class BlockedState {


    private static Thread threadA;
    private static Thread threadB;

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        threadA = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 线程A的状态 " + threadA.getState());
                    System.out.println(Thread.currentThread().getName() + " 线程B的状态 " + threadB.getState());
                    Thread.sleep(10000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-A");

        threadB = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 线程A的状态 " + threadA.getState());
                System.out.println(Thread.currentThread().getName() + " 线程B的状态 " + threadB.getState());
                try {
                    Thread.sleep(10000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-B");

        threadA.start();
        threadB.start();


    }

}


//                System.out.println(Thread.currentThread().getName() + "  before wait() " + threadA.getState() );
