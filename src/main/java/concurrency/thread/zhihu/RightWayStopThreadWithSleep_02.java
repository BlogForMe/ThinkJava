package concurrency.thread.zhihu;

//阻塞情况下，如何停止线程
public class RightWayStopThreadWithSleep_02 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                int num = 0;
                while ((num <= 300) && (!Thread.currentThread().isInterrupted())) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}