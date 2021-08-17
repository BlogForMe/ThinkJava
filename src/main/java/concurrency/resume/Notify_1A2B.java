package concurrency.resume;


/**
 * 如何让两个线程循环交替打印
 */
public class Notify_1A2B {
    private static Thread t1;
    private static Thread t2;


    public static void main(String[] args) throws InterruptedException {
        Notify_1A2B o = new Notify_1A2B();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        t1 = new Thread(() -> {
            synchronized (o) {
                for (char c : aI) {
                    System.out.print(c);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        t2 = new Thread(() -> {
            try {
                synchronized (o) {
                    for (char c : aC) {
                        System.out.print(c);
                        o.notify();
                        o.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();


    }
}
