package concurrency.thread.lagou.jmm;

public class VisibilityThread {
    private static volatile boolean initFlag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("waiting data...");
            while (!initFlag) {

            }
            System.out.println("=========success");
        }).start();

        Thread.sleep(2000);

        initFlag = false;

        new Thread(()->prepareData()).start();
    }

    private static void prepareData() {
        System.out.println("prepareData");
        initFlag = true;
        System.out.println("prepare data end..");
    }
}
