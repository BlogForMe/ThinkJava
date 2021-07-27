package concurrency.state;

public class TIMED_WAITING {


    private static Thread threadA;

    public static void main(String[] args) throws InterruptedException {
        threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " " + threadA.getState());
            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
            }
        }, "Thread-A");
        threadA.start();
        Thread.sleep(2000L);
        System.out.println(Thread.currentThread().getName() + " 线程A的状态 " + threadA.getState());
    }

}


