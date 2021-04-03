package concurrency.thread.zhihu;

import java.util.concurrent.TimeUnit;

/**
 * 如果线程在每次迭代后都阻塞，如何中断
 *
 * 中断后停止线程,thread.isInterrupted()被还原成了false
 */


public class RightWayStopThreadWithSleepEveryLoop_03 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                int num = 0;
                while (num <= 10000) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        System.out.println("before wait " + thread.isInterrupted());
        Thread.sleep(10);
//        TimeUnit.SECONDS.sleep(1);
        System.out.println("after wait " + thread.isInterrupted());
    }
}
