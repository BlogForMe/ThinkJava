package concurrency.thread.zhihu;


/**
 * 未阻塞情况下，如何停止线程
 * run 方法内没有 sleep 或 wait 方法时，停止线程
 */

public class RightWayStopThreadWithoutSleep_01 implements Runnable {
    @Override
    public void run() {
        int num = 0;
        while (num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
        System.out.println("任务运行结束");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep_01());
        thread.start();
        Thread.sleep(10);
        thread.interrupt(); // 通知线程停止
    }
}
