package concurrency.zhihu;

/**
 * 4. 中断的最佳实践
 */
public class RightWayStopThreadInProd_04 implements  Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("业务逻辑");
            throwInMethod();
        }
    }

    private void throwInMethod() {
        // 这种方式并不好，在很低级的层次处理了异常
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd_04());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
