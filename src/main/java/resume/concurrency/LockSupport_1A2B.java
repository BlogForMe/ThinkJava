package resume.concurrency;

import java.util.concurrent.locks.LockSupport;

public class LockSupport_1A2B {
    private static Thread t1;
    private static Thread t2;

    public static void main(String[] args) throws InterruptedException {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
            LockSupport.unpark(t2);
        });
        t2 = new Thread(() -> {
            for (char c : aC) {
                System.out.print(c);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
//        System.out.println("t1  " + t1.getState());
//        System.out.println("t2  " + t2.getState());
        t1.join();
        t2.join();


    }
}
