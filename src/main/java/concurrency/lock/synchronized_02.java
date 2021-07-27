package concurrency.lock;

import java.util.concurrent.TimeUnit;

public class synchronized_02 implements Runnable {
    static int i = 0;

    /**
     * 对于全局
     */
    public static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //new新实例
        Thread t1 = new Thread(new synchronized_02());
        t1.start();

        for (int j = 0; j < 1000000; j++) {
            increase();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(i);
    }
}
//————————————————
//        版权声明：本文为CSDN博主「zejian_」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/javazejian/article/details/72828483