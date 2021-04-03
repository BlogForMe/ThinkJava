package concurrency.thread.zhihu;

/**
 * 最佳实践2
 * 在 catch 子语句中调用 Thread.currentThread().interrupt() 来恢复设置中断状态，以便于在后续的执行中，依然能够检查到刚才发生了中断
 */
public class RightWayStopThreadInProd2 implements  Runnable{
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("程序运行结束");
                break;
            }
            System.out.println("业务逻辑...");
            reInterrupt();
        }
    }

    private void reInterrupt() {
        // 即使是想自己处理异常，也要继续往上报
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
