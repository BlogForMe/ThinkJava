package concurrency.lagou.jmm;

public class NoVolatile {

    public static void main(String[] args) {
        Runnable1 runnable1 = new Runnable1();
        Runnable2 runnable2 = new Runnable2();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" runnable1.done volatile " + runnable1.done);
        System.out.println(" runnable2.done         " + runnable2.done);
    }
}

class Runnable1 implements Runnable {
    volatile boolean done = false;
    public static int num=1000000;

    @Override
    public void run() {
        for (int i = 0; i < Runnable1.num; i++) {
            done = (!done);
//            System.out.println(done);
        }
    }
}


class Runnable2 implements Runnable {
    boolean done = false;

    @Override
    public void run() {
        for (int i = 0; i < Runnable1.num; i++) {
            done = (!done);
        }
    }
}

